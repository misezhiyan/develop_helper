<template>
    <div>
        <el-breadcrumb>
            <el-breadcrumb-item v-for="(crumb, index) in breadcrumb" :key="index">
                {{ crumb.meta.title }}
            </el-breadcrumb-item>
        </el-breadcrumb>
    </div>
</template>

<script setup lang="ts">
import { Ref, ref, watch } from "vue";
import { useRoute, RouteLocationMatched } from "vue-router";
const route = useRoute();

const breadcrumb: Ref<RouteLocationMatched[]> = ref([])

const getBreadCrumb = () => {
    // 过滤路由信息
    let matched = route.matched.filter((item) => item.meta && item.meta.title && item.children.length != 1)

    // 第一条数据
    const first = matched[0];
    if (first.path != '/index') {
        matched = [{ path: '/index', meta: { title: '首页' } } as any].concat(matched)
    }
    breadcrumb.value = matched
}

// 监控，如果路由发生变化， 则面包屑发生变化
watch(() => route.path, () => {
    getBreadCrumb()
})

</script>

<style lang="scss"></style>