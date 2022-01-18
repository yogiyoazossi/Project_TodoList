export const state = () => ({
  todoItems: [
    {
      todoIdx: 1,
      todoTitle: '1',
      todoContent: '1',
      todoUpdatedDatetime: '2021-10-12 07:22',
      todoCreatedDatetime: '2021-10-12 07:22',
      todoCompleted: 1,
      todoImportance: 1,
    },
    {
      todoIdx: 6,
      todoTitle: '5',
      todoContent: 'qwe',
      todoUpdatedDatetime: '2021-11-30 08:09',
      todoCreatedDatetime: '2021-11-30 08:09',
      todoCompleted: 5,
      todoImportance: 5,
    },
    {
      todoIdx: 4,
      todoTitle: '2',
      todoContent: 'fasfasfasfas',
      todoUpdatedDatetime: '2021-11-30 08:02',
      todoCreatedDatetime: '2021-11-30 08:02',
      todoCompleted: 2,
      todoImportance: 2,
    },
  ],
})

export const mutations = {
  // TodoInput
  addTodo(state, payload) {},

  // TodoListCards
  toggleImportantTodo(state, payload) {},
  toggleCompletedTodo(state, payload) {},
  editTodo(state, payload) {},
  removeTodo(state, payload) {
    // Card 삭제 및 Refresh
  },
}

export const actions = {}
