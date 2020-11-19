<template>
  <el-table :data="tableData" border style="width: 100%">
    <el-table-column prop="coinCode" label="币种" width="180"> </el-table-column>
    <el-table-column prop="quantity" label="数量" width="180"> </el-table-column>
    <el-table-column prop="money" label="金额"> </el-table-column>

    <el-table-column label="操作" width="180">
      <template slot-scope="scope">
        <el-button
          type="primary"
          @click="handleEditClick(scope.$index, scope.row)"
          size="mini"
          >编辑</el-button
        >
        <el-button
          type="danger"
          size="mini"
          @click="handleDelClick(scope.$index, scope.row)"
          >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>
</template>
<script>
import axios from "axios";
import qs from "qs";

const debug = process.env.NODE_ENV !== 'production'
const axInstance = axios.create({
    baseURL: debug ? 'api' : 'http://1.3.4.5.6:89',
    timeout: 10000,
    responseType: 'json',
    withCredentials: false, // 表示跨域请求时是否需要使用凭证
    headers: {
        token: store.state.axios.token,
        'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
    }
})
// 声明基础访问地址
axios.defaults.baseURL = 'http://localhost:8188/srv01'
axios.defaults.withCredentials = true;//跨域  
axios.defaults.headers = {
    "Content-Type": "application/x-www-form-urlencoded"
}
axios.defaults.transformRequest = function(data){
    data = qs.stringify(data);
    return data;
}
export default {
  name: "TableData",
  data() {
    return {
      tableData: [],
      addBox: false,
      editBox: false,
      user: {},
      editIndex: "",
      addUserData: {
        date: "",
        name: "",
        address: "",
      },
    };
  },
  mounted: function() {
    this.loadData();
  },
  methods: {
    loadData() {
      axios.post("/bca/trading-record/", (result) => {
        this.tableData = result.data;
      });
    },
    handleEditClick(index, row) {
      this.editBox = true;
      this.user = row;
      this.editIndex = index;
    },

    // eslint-disable-next-line no-unused-vars
    handleDelClick(index, row) {
      this.$confirm("此操作将删除该用户, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        this.tableData.splice(index, 1);
        this.$message({
          showClose: true,
          message: "删除成功",
          type: "success",
        });
      });
    },
    handleClose(done) {
      done();
    },
    handleEditUser() {
      this.tableData.splice(this.editIndex, 1, this.user);
      this.$message({ showClose: true, message: "修改成功", type: "success" });
      this.editBox = false;
    },
    handleAddClick() {
      this.addBox = true;
    },
    handleAddUser() {
      let strDate = dateFormat("YYYY-mm-dd", this.addUserData.date);
      this.addUserData.date = strDate;
      this.tableData.push(this.addUserData);
      this.addBox = false;
      this.addUserData = {};
      this.$message({ showClose: true, message: "添加成功", type: "success" });
    },
  },
};

function dateFormat(fmt, date) {
  let ret;
  const opt = {
    "Y+": date.getFullYear().toString(), // 年
    "m+": (date.getMonth() + 1).toString(), // 月
    "d+": date.getDate().toString(), // 日
    "H+": date.getHours().toString(), // 时
    "M+": date.getMinutes().toString(), // 分
    "S+": date.getSeconds().toString(), // 秒
    // 有其他格式化字符需求可以继续添加，必须转化成字符串
  };
  for (let k in opt) {
    ret = new RegExp("(" + k + ")").exec(fmt);
    if (ret) {
      fmt = fmt.replace(
        ret[1],
        ret[1].length == 1 ? opt[k] : opt[k].padStart(ret[1].length, "0")
      );
    }
  }
  return fmt;
}
</script>
