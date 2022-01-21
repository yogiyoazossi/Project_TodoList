<template>
  <div>
    <v-card>
      <!-- 중요 / 수정 / 삭제 버튼 -->
      <v-card-actions class="d-flex justify-space-around">
        <v-btn x-small text @click="toggleTodoImportant(todoItem)">
          <v-icon v-if="todoItem.todoImportant" dark> mdi-star </v-icon>
          <v-icon v-else dark> mdi-star-outline </v-icon>
        </v-btn>
        <v-btn x-small text @click="toggleTodoCompleted(todoItem)">
          <v-icon dark> mdi-check </v-icon>
        </v-btn>
        <btn-editTodo :todoItem="todoItem" />
        <v-btn x-small text @click="removeTodo(todoItem)">
          <v-icon dark> mdi-delete </v-icon>
        </v-btn>
      </v-card-actions>
    </v-card>

    <v-card outlined class="overflow-y-auto" height="250">
      <v-divider />

      <!-- 컨텐츠 -->
      <v-card-text>
        <!-- TODO: 데이터 크기가 다를 때 어떻게 스크롤 표현할 수 있지? -->
        <div :class="{ textCompleted: todoItem.todoCompleted }">
          <pre>{{ todoItem.todoContent }}</pre>
        </div>
      </v-card-text>
    </v-card>

    <v-divider />

    <v-card>
      <!-- 생성일/완료일 -->
      <v-card-text>
        <v-row>
          <v-spacer />
          {{ todoItem.todoCreatedDatetime }} ~
          {{ todoItem.todoUpdatedDatetime }}
        </v-row>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
import BtnEditTodo from '~/components/todo/BtnEditTodo'

export default {
  components: {
    BtnEditTodo,
  },

  props: {
    todoItem: {
      type: Object,
      required: true,
    },
  },

  methods: {
    // TODO: todoCompleted, todoImportance를 Mutations 로 변경하면 될듯.
    async toggleTodoImportant(todoItem) {
      await this.$store.dispatch('todo/toggleTodoImportant', { todoItem })
    },

    async toggleTodoCompleted(todoItem) {
      await this.$store.dispatch('todo/toggleTodoCompleted', { todoItem })
    },

    async removeTodo(todoItem) {
      await this.$store.dispatch('todo/removeTodo', { todoItem })
      await this.$store.dispatch('todo/loadTodoItems')
    },
  },
}
</script>

<style scoped>
.textCompleted {
  text-decoration: line-through;
  /* color: #b3adad; */
  color: red;
}

.scroll {
  overflow-y: scroll;
}
</style>
