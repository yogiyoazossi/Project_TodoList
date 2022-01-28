<template>
  <v-app dark>
    <v-app-bar fixed app>
      <v-tabs>
        <v-tab @click="menu(1)">업데이트된 날짜별 정리</v-tab>
        <v-tab @click="menu(2)">중요 메모</v-tab>
        <v-tab @click="menu(3)">완료된 메모</v-tab>
        <v-tab @click="menu(4)">기록한 순서대로</v-tab>
      </v-tabs>

      <v-spacer />
      <v-switch
        v-model="$vuetify.theme.dark"
        inset
        absolute
        label="Dark Mode"
        class="mt-5"
      />
    </v-app-bar>
    <v-main>
      <v-container>
        <Nuxt />
      </v-container>
    </v-main>
    <v-footer :absolute="!fixed" app>
      <span>&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>

<script>
export default {
  data() {
    return {
      fixed: false,
    }
  },

  methods: {
    menu(value) {
      if (value === 1) {
        this.$router.push('/todolist_updatedtime/')
      } else if (value === 2) {
        this.$router.push('/todolist_important/')
      } else if (value === 3) {
        this.$router.push('/todolist_completed/')
      } else {
        this.$router.push('/todolist/')
      }
    },
  },
}
</script>
