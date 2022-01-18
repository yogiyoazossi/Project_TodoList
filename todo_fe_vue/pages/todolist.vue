<template>
  <div>
    <!-- TODO: 인풋 컴포넌트로 뺄까? -->
    <!-- TODO: 중요/완료/미완료로 분류 가능하게. -->

    <!-- TodoList Input -->
    <v-container>
      <v-card>
        <v-card-text>
          <v-textarea label="내용 입력" outlined />
        </v-card-text>

        <v-card-actions>
          <v-spacer />
          <v-btn>Addo</v-btn>
          <v-btn>Cleardo</v-btn>
        </v-card-actions>
      </v-card>
    </v-container>

    <!-- TodoList Cards -->
    <v-container>
      <v-row>
        <v-col v-for="p in todoItems" :key="p.idx" cols="3">
          <!-- TODO: 카드 크기 고정 필요 -->
          <!-- TODO: 휴지통 + 휴지통 비우기 -->
          <todo-list-cards :todoItem="p" />
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import TodoListCards from '~/components/TodoListCards'
export default {
  components: {
    TodoListCards,
  },

  data() {
    return {
      todoItems: [
        {
          idx: 1,
          content: 'woobeom1',
          textCompleted: true,
          important: true,
        },
        {
          idx: 2,
          content: 'woobeom2',
          textCompleted: false,
          important: false,
        },
      ],
    }
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
