<template>
  <el-tabs v-model="activeKey" type="card" @tab-click="clickHandle" @tab-remove="removeTab"
    @contextmenu.prevent.native="openContextMenu($event)">
    <el-tab-pane v-for="tab in tabList" :closable="tab.path != '/index'" :key="tab.path" :label="tab.title"
      :name="tab.path">
      {{ tab.content }}-{{ tab.path }}
    </el-tab-pane>
  </el-tabs>

  <ul v-show="contextMenuVisible" :style="{ left: left + 'px', top: top + 'px' }" class="contextmenu">
    <li @click="closeAllTabs">关闭所有</li>
    <li @click="closeOtherTabs('left')">关闭左边</li>
    <li @click="closeOtherTabs('right')">关闭右边</li>
    <li @click="closeOtherTabs('other')">关闭其它</li>
  </ul>
</template>
<script lang="ts" setup>
import { ref, computed, watch, onMounted, Ref } from 'vue'
import { useStore } from 'vuex'
import { useRoute, useRouter } from 'vue-router'
import { Itab } from '@/store/type'

const store = useStore()
const route = useRoute()
const router = useRouter()
const tabList = computed(() => {
  return store.getters.getAddTab
})

// 索引
const activeKey = ref("")

// 添加tab
const addTab = () => {
  const { meta, path } = route
  const tab: Itab = {
    path: path,
    title: meta.title as string
  }
  store.commit('addTab', tab)
}

// 监控
watch(() => route.path, () => {
  activeKey.value = route.path
  addTab()
})

// 点击tab
const clickHandle = (event: any) => {
  router.push({ path: event.props.name })
}

// 关闭标签
const removeTab = (targetName: string) => {
  // 删除当前标签
  if (activeKey.value === targetName) {
    tabList.value.forEach((tab: Itab, index: number) => {
      if (tab.path === targetName) {
        const nextTab = tabList.value[index + 1] || tabList.value[index - 1]
        if (nextTab) {
          activeKey.value = nextTab.path
          router.push({ path: nextTab.path })
        }
      }
    });
  }
  store.commit('closeCurrentTab', targetName)
}

// 刷新缓存数据
const refresh = () => {
  window.addEventListener('beforeunload', () => {
    sessionStorage.setItem('TABS_ROUTES', JSON.stringify(tabList.value))
    sessionStorage.setItem('TABS_ACTIVE', activeKey.value)
  })

  let session = sessionStorage.getItem('TABS_ROUTES')
  let activeTab = sessionStorage.getItem('TABS_ACTIVE') as string

  if (session) {
    let tabItem = JSON.parse(session)
    if (tabItem.length > 0) {
      tabItem.forEach((tab: Itab) => {
        store.commit('addTab', tab)
      })
    } else {
      store.commit('addTab', {
        path: '/index',
        title: '首页'
      })
      activeTab = '/index'
      router.push({ path: '/index' })
    }
  } else {
    store.commit('addTab', {
      path: '/index',
      title: '首页'
    })
    activeTab = '/index'
    router.push({ path: '/index' })
  }

  activeKey.value = activeTab
}

// 页面初始化
onMounted(() => {
  // 刷新保存数据
  refresh()
})

// 右键菜单显示
const contextMenuVisible: Ref<boolean> = ref(false)
const left = ref('')
const top = ref('')
const openContextMenu = (e: any) => {
  if (e.srcElement.id) {
    let currentContextTabId = e.srcElement.id.split("-")[1]
    store.commit("saveCurContextTableId", currentContextTabId)
    contextMenuVisible.value = true
    left.value = e.clientX
    top.value = e.clientY + 10
  }
}

// 关闭所有标签
const closeAllTabs = () => {
  store.commit('closeAllTabs')
  contextMenuVisible.value = false
  activeKey.value = '/index'
  router.push({ path: '/index' })
}

// 关闭其它标签(左，右，其它)
const closeOtherTabs = (direction: string) => {
  store.commit('closeOtherTabs', direction)
  contextMenuVisible.value = false
  const curTab = computed(() => {
    return store.getters.getCurMenuTabId
  })
  activeKey.value = curTab.value
  router.push({ path: curTab.value })
}

// 监控右键菜单，如果有点击，关闭
watch(() => contextMenuVisible.value, () => {
  if (contextMenuVisible.value) {
    window.addEventListener("click", () => contextMenuVisible.value = false)
  } else {
    window.removeEventListener("click", () => contextMenuVisible.value = false)
  }
})
</script>

<style lang="scss" scoped>
.contextmenu {
  width: 100px;
  margin: 0;
  border: 1px solid #ccc;
  background: #fff;
  z-index: 3000;
  position: absolute;
  list-style-type: none;
  padding: 5px 0;
  border-radius: 4px;
  font-size: 14px;
  color: #333;
  box-shadow: 2px 2px 3px 0 rgba(0, 0, 0, 0.2);

  li {
    margin: 0;
    padding: 7px 16px;

    &:hover {
      background: #f2f2f2;
      cursor: pointer
    }
  }
}
</style>