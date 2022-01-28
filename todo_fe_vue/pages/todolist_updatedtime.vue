<template>
  <div>
    <!-- TODO: 인풋 컴포넌트로 뺄까? -->
    <!-- TODO: 중요/완료/미완료로 분류 가능하게. -->
    <v-container>
      <v-row>
        <v-col cols="4">
          <todo-input-card />
        </v-col>
        <v-col v-for="p in todoItems" :key="p.idx" cols="4">
          <!-- TODO: 휴지통 + 휴지통 비우기 -->
          <todo-list-cards :todoItem="p" />
        </v-col>
      </v-row>
    </v-container>
    <alert :alertMsg="alertMsg" />
  </div>
</template>

<script>
import TodoInputCard from '~/components/todo/TodoInputCard'
import TodoListCards from '~/components/todo/TodoListCards'
import Alert from '~/components/common/Alert'

export default {
  components: {
    TodoInputCard,
    TodoListCards,
    Alert,
  },

  data() {
    return {
      alertMsg: '완료된 메모는 중요함에 넣을 수 없습니다.',
    }
  },

  fetch({ store }) {
    // store.dispatch('todo/loadTodoItems')
    store.dispatch('todo/loadTodoItemsOrderByUpdatedDatetime')
  },

  computed: {
    todoItems() {
      return this.$store.state.todo.todoItems
    },
  },

  mounted() {
    // this.$store.dispatch('todo/loadTodoItems')
    this.$store.dispatch('todo/loadTodoItemsOrderByUpdatedDatetime')
  },

}
</script>

<style scoped>
.textCompleted {
  text-decoration: line-through;
  /* color: #b3adad; */
  color: red;
}
</style>
