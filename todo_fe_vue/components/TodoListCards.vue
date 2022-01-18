<template>
  <div>
    <v-card>
      <!-- TODO: 중요는 어떻게? -->
      <!-- TODO: 완료표시는 어떻게? -->
      <!-- 중요 / 수정 / 삭제 버튼 -->
      <v-card-actions class="d-flex justify-space-around">
        <v-btn small>
          <v-icon dark v-if="todoItem.important"> mdi-star </v-icon>
          <v-icon dark v-else> mdi-star-outline </v-icon>
        </v-btn>
        <v-btn small><v-icon dark> mdi-check </v-icon></v-btn>
        <v-btn small><v-icon dark> mdi-pencil </v-icon></v-btn>
        <v-btn small><v-icon dark> mdi-delete </v-icon></v-btn>
      </v-card-actions>
      <v-divider />

      <!-- 컨텐츠 -->
      <v-card-text outlined>
        <!-- TODO: 데이터 크기가 다를 때 어떻게 스크롤 표현할 수 있지? -->
        <div :class="{ textCompleted: todoItem.textCompleted }">
          {{ todoItem.idx }} // {{ todoItem.content }}
        </div>
      </v-card-text>

      <v-divider />

      <!-- 생성일/완료일 -->
      <v-card-text>
        <v-row>Created: 생성일</v-row>
        <v-row>Updated: 완료</v-row>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
export default {
  props: {
    todoItem: {
      type: Object,
      required: true,
    },
  },

  methods: {
    //   TODO: textCompleted, important를 Mutations 로 변경하면 될듯.
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
