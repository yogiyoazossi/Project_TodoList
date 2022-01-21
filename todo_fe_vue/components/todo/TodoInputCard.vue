<template>
  <div>
    <v-card height="323">
      <v-container>
        <v-form ref="form" v-model="valid" @submit.prevent="addTodoSubmitForm">
          <v-textarea
            v-model="content"
            label="내용 입력"
            outlined
            height="250"
            style="margin-bottom: -30px"
          />
          <v-card-actions>
            <v-spacer />
            <v-btn :disabled="!valid" color="green" type="submit" text>
              기록
            </v-btn>
            <v-btn color="green" text @click="clearTodo">클리어</v-btn>
          </v-card-actions>
        </v-form>
      </v-container>
    </v-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      valid: false,
      content: '',
    }
  },

  methods: {
    clearTodo() {
      this.content = ''
    },

    async addTodoSubmitForm() {
      if (this.$refs.form.validate()) {
        await this.$store.dispatch('todo/addTodo', {
          todoContent: this.content,
        })

        await this.$store.dispatch('todo/loadTodoItems')
        this.content = ''
      }
    },
  },
}
</script>

<style scoped></style>
