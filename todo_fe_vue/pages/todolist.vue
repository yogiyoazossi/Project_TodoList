<template>
  <div>
    <v-list :rounded="rounded">
      <v-list-item-group color="primary">
        <v-list-item v-for="(item, index) in postList" :key="index">
          <!-- CheckBox Button -->
          <v-list-item-action>
            <v-btn v-if="item.checkbox" icon>
              <v-icon color="grey lighten-1">mdi-checkbox-intermediate</v-icon>
            </v-btn>
            <v-btn v-else icon>
              <v-icon color="grey lighten-1">mdi-checkbox-blank-outline</v-icon>
            </v-btn>
          </v-list-item-action>

          <!-- Contents-->
          <v-list-item-content>
            <v-list-item-title :class="{ textCompleted: item.checkbox }">{{
              item.content
            }}</v-list-item-title>
            <v-list-item-subtitle>woobeom / woobeom</v-list-item-subtitle>
          </v-list-item-content>

          <!-- Delete Button -->
          <v-list-item-action>
            <v-btn icon>
              <v-icon color="grey lighten-1">mdi-trash-can</v-icon>
            </v-btn>
          </v-list-item-action>
        </v-list-item>
      </v-list-item-group>
    </v-list>
  </div>
</template>

<script>
export default {
  data() {
    return {
      rounded: true,
    }
  },

  computed: {
    postList() {
      return this.$store.state.postList
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
</style>
