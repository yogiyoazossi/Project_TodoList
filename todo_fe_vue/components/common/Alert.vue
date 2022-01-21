<template>
  <div>
    <v-container>
      <v-alert v-if="alert" border="top" color="red lighten-2" dark>
        {{ alertMsg }}
      </v-alert>
    </v-container>
  </div>
</template>

<script>
export default {
  props: {
    alertMsg: {
      type: String,
      required: true,
    },
  },

  computed: {
    alert() {
      return this.$store.state.todo.alert
    },
  },
}
</script>

<style scoped></style>
