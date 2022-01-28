export const state = () => ({
  alert: false,
  menu: 1,

  todoItems: [],
})

export const mutations = {
  // pages/Todolist.vue
  loadTodoItems(state, payload) {
    // state.todoItems = state.todoItems.concat(payload)
    state.todoItems = payload
  },

  // components/todo/TodoInput.vue
  addTodo(state, payload) {
    // TODO: 성공했다는 메세지가 필요할듯?
  },

  // components/todo/TodoListCards.vue
  toggleTodoImportant(state, payload) {
    const index = state.todoItems.findIndex(
      (v) => v.todoIdx === payload.todoItem.todoIdx
    )
    state.todoItems[index].todoImportant = !state.todoItems[index].todoImportant
  },

  // components/todo/TodoListCards.vue
  toggleTodoCompleted(state, payload) {
    const index = state.todoItems.findIndex(
      (v) => v.todoIdx === payload.todoItem.todoIdx
    )
    state.todoItems[index].todoCompleted = !state.todoItems[index].todoCompleted
  },

  // components/todo/TodoListCards.vue
  editTodo(state, payload) {},

  // components/todo/TodoListCards.vue
  removeTodo(state, payload) {
    // Card 삭제 및 Refresh
  },

  // components/todo/TodoListCards.vue
  toggleAlert(state) {
    state.alert = !state.alert
  },

  changeMenu(state, payload) {
    state.menu = payload
  },
}

export const actions = {
  // pages/Todolist.vue
  loadTodoItems({ commit }, payload) {
    this.$axios
      .get('http://localhost:8080/lists')
      .then((res) => {
        commit('loadTodoItems', res.data)
      })
      .catch(() => {})
  },

  loadTodoItemsOrderByUpdatedDatetime({ commit }, payload) {
    this.$axios
      .get('http://localhost:8080/lists/updatedtime')
      .then((res) => {
        commit('loadTodoItems', res.data)
      })
      .catch(() => {})
  },

  loadTodoItemsOrderByImportant({ state, commit }, payload) {
      this.$axios
        .get('http://localhost:8080/lists/important')
        .then((res) => {
          commit('loadTodoItems', res.data)
        })
        .catch(() => {})
  },

  loadTodoItemsOrderByCompleted({ commit }, payload) {
    this.$axios
      .get('http://localhost:8080/lists/completed')
      .then((res) => {
        commit('loadTodoItems', res.data)
      })
      .catch(() => {})
  },

  // components/todo/TodoInput.vue
  async addTodo({ commit }, payload) {
    await this.$axios
      .post('http://localhost:8080/post', {
        todoContent: payload.todoContent,
      })
      .then((res) => {
        // TODO: 성공했다는 메세지가 필요할듯?
      })
      .catch(() => {})
  },

  // components/todo/TodoListCards.vue
  toggleTodoImportant({ commit }, payload) {
    // SUCCESS: 완료된 메모는 중요함에 넣을 수 없습니다.
    if (payload.todoItem.todoCompleted) {
      commit('toggleAlert')
      setTimeout(() => {
        commit('toggleAlert')
      }, 2000)
    } else {
      commit('toggleTodoImportant', payload)
    }
  },

  // components/todo/TodoListCards.vue
  toggleTodoCompleted({ commit }, payload) {
    commit('toggleTodoCompleted', payload)
  },

  // components/todo/BtnEditTodo.vue
  async editTodo({ commit }, payload) {
    await this.$axios
      .put('http://localhost:8080/update/' + payload.todoIdx, {
        todoIdx: payload.todoIdx,
        todoContent: payload.todoContent,
        todoCompleted: payload.todoCompleted,
        todoImportant: payload.todoImportant,
        todoCreatedDatetime: payload.todoCreatedDatetime,
      })
      .then((res) => {
        // TODO: 성공했다는 메세지가 필요할듯?
      })
      .catch(() => {})
  },

  // components/todo/TodoListCards.vue
  async removeTodo({ commit }, payload) {
    await this.$axios
      .delete('http://localhost:8080/delete/' + payload.todoItem.todoIdx)
      .then((res) => {
        // TODO: 성공했다는 메세지가 필요할듯?
      })
      .catch(() => {})
  },
}
