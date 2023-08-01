<template>
    <div class="layout">
        <el-container>
            <el-aside :style="'width:' + autoWidth">
                <logoBar :collapsed="collapsed" />
                <menuBar :collapsed="collapsed" />
            </el-aside>
            <el-container>
                <el-header>
                    <el-row>
                        <!-- 菜单展开、折叠 -->
                        <el-icon style="font-size: 35px; margin-right: 15px;" @click="() => (collapsed = !collapsed)">
                            <component :is="collapsed ? Expand: Fold" />
                        </el-icon>
                        <headerBar style="margin-top: 10px;"/>
                    </el-row>
                </el-header>
                <el-main>
                    <tabBar/>
                    <appMain />
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script setup lang="ts">
import logoBar from "./components/logoBar/index.vue";
import menuBar from "./components/menuBar/index.vue";
import { ref, computed } from 'vue';
import { Expand, Fold } from '@element-plus/icons-vue'
import { isMobile } from '../utils/isMobile'
import appMain from './components/appMain/index.vue'
import headerBar from './components/headerBar/index.vue'
import tabBar from './components/tabBar/index.vue'

const collapsed = ref<boolean>(false)

const autoWidth = computed(() => {
    if (collapsed.value && isMobile()) {
        return '0px'
    } else if (collapsed.value) {
        return '68px'
    } else {
        return '200px'
    }
})
</script>

<style lang="scss">
.layout {
    display: flex;
    width: 100vw;
    height: 100vh;

    .el-header {
        display: flex;
        flex-wrap: nowrap;
        align-items: center;
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: $menuBg;
        color: #333;
        text-align: center;
        line-height: 200px;
        overflow: hidden;
    }

    // .el-main {
    //     background-color: #E9EEF3;
    //     color: #333;
    //     text-align: center;
    //     line-height: 160px;
    // }
}
</style>