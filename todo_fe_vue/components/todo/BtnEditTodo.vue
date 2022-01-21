<template>
  <div>
    <v-dialog
      v-model="boolDialog"
      transition="dialog-bottom-transition"
      max-width="700"
    >
      <template #activator="{ on, attrs }">
        <v-btn x-small text v-bind="attrs" v-on="on" @click="toggleDialog">
          <v-icon dark> mdi-pencil </v-icon>
        </v-btn>
      </template>
      <v-card>
        <v-container>
          <v-form
            ref="form"
            v-model="valid"
            @submit.prevent="editTodoSubmitForm(todoItem)"
          >
            <pre id="json">{{ todoItem }}</pre>
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

  // fetch({ store }) {
  //   store.dispatch('todo/loadTodoItems')
  //   this.content = this.todoItem.todoContent
  // },

  mounted() {
    this.content = this.todoItem.todoContent
  },

  methods: {
    toggleDialog() {
      this.content = this.todoItem.todoContent
      this.boolDialog = !this.boolDialog
    },

    async editTodoSubmitForm(todoItem) {
      await this.$store.dispatch('todo/editTodo', {
        todoIdx: todoItem.todoIdx,
        todoContent: this.content,
        todoCompleted: todoItem.todoCompleted,
        todoImportant: todoItem.todoImportant,
        todoCreatedDatetime: todoItem.todoCreatedDatetime,
      })
      await this.$store.dispatch('todo/loadTodoItems')
      this.content = ''
      await this.toggleDialog()
    },
  },
}
</script>

<style scoped></style>
