<script setup>
import {deleatePost} from '@/net'
import {ref, onMounted} from "vue";
import {message} from 'ant-design-vue';
import router from "@/router/index.js";
import {getPostsList} from '@/net'

const confirm = (id) => {
  deleatePost(id, () => {
    console.log(id);
    message.success('删除成功');
    setTimeout(() => {
      window.location.reload();
    }, 1000);
  });

};
const cancel = (e) => {
  console.log(e);
  message.error('删除取消');
};
const dataSource = ref([])


function fetchData(current, pageSize) {
  getPostsList(current, pageSize, (res) => {
    dataSource.value = res.items;
    // 更新总数据量，确保分页器正确显示
    paginations.value.total = res.total;
  });
}


const columns = [
  {
    title: 'id',
    dataIndex: 'id',
    key: 'id',
  },
  {
    title: 'title',
    dataIndex: 'title',
    key: 'title',
  },
  {
    title: 'createTime',
    dataIndex: 'createTime',
    key: 'createTime',
  },
  {
    title: 'urlName',
    dataIndex: 'urlName',
    key: 'urlName',
  },
  {
    title: 'Action',
    key: 'action',
  }
]


const paginations = ref({
  current: 1,
  total: 0,
  pageSize: 10,//每页中显示10条数据
  showSizeChanger: true,
  pageSizeOptions: ["10", "20", "50", "100"],//每页中显示的数据
  showTotal: total => `共有 ${total} 条数据`,  //分页中显示总的数据
})

function handleTableChange(pagination) {
  paginations.value.current = pagination.current;
  paginations.value.pageSize = pagination.pageSize;
  fetchData(pagination.current, pagination.pageSize);

}

onMounted(() => {
  fetchData(paginations.value.current, paginations.value.pageSize);
})

function toWrite() {
  router.push('/admin/newpost')
}
</script>

<template>

  <div class="flex flex-row-reverse">
    <a-button class="m-4" type="primary" @click="toWrite">添加文章</a-button>
  </div>
  <div class="m-3">
    <a-table :dataSource="dataSource" :columns="columns" :pagination="paginations" @change="handleTableChange" bordered
             class="h-full">

      <template #bodyCell="{ column, record }">

        <template v-if="column.key === 'action'">
        <span>
              <router-link :to="`/admin/postsEdit/${record.id}`">编辑</router-link>
              <a-divider type="vertical"/>
          <a-popconfirm
              title="Are you sure delete this task?"
              ok-text="Yes"
              cancel-text="No"
              @confirm="confirm(record.id)"
              @cancel="cancel"
          >
            <a href="#">删除</a>
          </a-popconfirm>
        </span>
        </template>
      </template>
      <template #title>文章列表</template>
    </a-table>


  </div>
</template>

<style scoped>

</style>
