<script setup>
import {get,deleatePost} from '@/net'
import {ref,computed} from "vue";
import { message } from 'ant-design-vue';
const confirm = (id) => {
  deleatePost(id,()=>{
    console.log(id);
    message.success('删除成功' );
    setTimeout(() => {
      window.location.reload();
    }, 1000);
  });

};
const cancel = (e) => {
  console.log(e);
  message.error('删除取消');
};
const dataSource=ref([])

get('http://127.0.0.1:8080/cms/blog/article?page=1&limit=20',(res)=>{
 dataSource.value = res.items
})



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
//
// //分页
// const paginations = ref({
//   pageSize: 10, //每页中显示10条数据
//   showSizeChanger: true,
//   pageSizeOptions: ['10', '20', '50'], //每页中显示的数据
//   ShowSizeChange: (current, pageSize) => this.pageSize = pageSize
// })
//
//
//
// function handleTableChange(pagination, filters, sorter) {
//   paginations.value.current = pagination.current;
//   paginations.pageSize = pagination.pagesize;
// }

const paginations =  ref({
  total: 0,
      pageSize: 10,//每页中显示10条数据
      showSizeChanger: true,
      pageSizeOptions: ["10", "20", "50", "100"],//每页中显示的数据
      showTotal: total => `共有 ${total} 条数据`,  //分页中显示总的数据
})
function handleTableChange(pagination) {
  paginations.value.current = pagination.current;
  paginations.value.pageSize = pagination.pageSize;
}

</script>

<template>


  <div class="m-3">
    <a-table :dataSource="dataSource" :columns="columns" :pagination="paginations"  @change="handleTableChange" bordered class="h-full">

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
