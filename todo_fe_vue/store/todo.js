export const state = () => ({
  alert: false,
  // todoItems: [
  //   {
  //     todoIdx: 1,
  //     todoTitle: '1',
  //     todoContent: '1',
  //     todoCreatedDatetime: '2021-10-12 07:22',
  //     todoUpdatedDatetime: '2021-10-12 07:22',
  //     todoImportant: false,
  //     todoCompleted: true,
  //   },
  //   {
  //     todoIdx: 6,
  //     todoTitle: '5',
  //     todoContent: 'qwe',
  //     todoCreatedDatetime: '2021-11-30 08:09',
  //     todoUpdatedDatetime: '2021-11-30 08:09',
  //     todoImportant: true,
  //     todoCompleted: true,
  //   },
  //   {
  //     todoIdx: 4,
  //     todoTitle: '2',
  //     todoContent: 'fasfasfasfas',
  //     todoCreatedDatetime: '2021-11-30 08:02',
  //     todoUpdatedDatetime: '2021-11-30 08:02',
  //     todoImportant: true,
  //     todoCompleted: false,
  //   },
  // ],

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
