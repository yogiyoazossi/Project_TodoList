<template>
  <div>
    <v-dialog
      v-model="boolDialog"
      transition="dialog-bottom-transition"
      max-width="700"
    >
      <template #activator="{ on, attrs }">
        <v-btn x-small text v-bind="attrs" v-on="on" @Click="toggleDialog">
          <v-icon dark> mdi-pencil </v-icon>
        </v-btn>
      </template>
      <v-card>
        <v-container>
          <v-form
            ref="form"
            v-model="valid"
            @submit.prevent="editTodoSubmitForm"
          >
            <v-textarea
              v-model="content"
              label="내용 입력"
              outlined
              style="margin-bottom: -20px"
            />
            <v-card-actions>
              <v-spacer />
              <v-btn text type="submit">변경</v-btn>
              <v-btn text @click="toggleDialog">취소</v-btn>
            </v-card-actions>
          </v-form>
        </v-container>
      </v-card>
    </v-dialog>
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

  data() {
    return {
      boolDialog: false,
      valid: false,
      content: '',
    }
  },

  mounted() {
    this.content = this.todoItem.todoContent
  },

  methods: {
    toggleDialog() {
      this.boolDialog = !this.boolDialog
    },

    async editTodoSubmitForm() {
      console.log(this.todoItem)
      await this.toggleDialog()
      await this.$store.dispatch('todo/editTodo', {
        todoIdx: this.todoItem.todoIdx,
        todoContent: this.content,
        todoCompleted: this.todoItem.todoCompleted,
        todoImportant: this.todoItem.todoImportant,
        todoCreatedDatetime: this.todoItem.todoCreatedDatetime,
      })
      await this.$store.dispatch('todo/loadTodoItems')
    },
  },
}
</script>

<style scoped></style>
