<template>
  <v-app dark>
    <v-app-bar fixed app>
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
}
</script>
