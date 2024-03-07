<script setup>
import {get,deleatePost} from '@/net'
import {ref} from "vue";
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

get('http://127.0.0.1:8080/cms/blog/article',(res)=>{
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
</script>

<template>


  <div>
    <a-table :dataSource="dataSource" :columns="columns" class="">

      <template #bodyCell="{ column, record }">

        <template v-if="column.key === 'action'">
        <span>
              <router-link to="/postEdit">编辑</router-link>
              <a-divider type="vertical"/>
<!--              <router-link to="/">删除</router-link>-->
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
    </a-table>


  </div>
</template>

<style scoped>

</style>
