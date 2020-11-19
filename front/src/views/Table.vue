<template>
  <el-table :data="tableData" border style="width: 100%">
    <el-table-column prop="date" label="日期" width="180"> </el-table-column>
    <el-table-column prop="name" label="姓名" width="180"> </el-table-column>
    <el-table-column prop="address" label="地址"> </el-table-column>

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
export default {
  name: "TableData",
  data() {
    return {
      tableData: [
        {
          date: "2016-03-02",
          name: "张三",
          address: "广州市天河区金沙江路 1518 弄",
        },
        {
          date: "2016-04-06",
          name: "李四",
          address: "广州市黄埔区金沙江路 1517 弄",
        },
        {
          date: "2016-08-01",
          name: "王五",
          address: "北京市金沙江路 1519 弄",
        },
        {
          date: "2016-06-03",
          name: "赵六",
          address: "上海市普陀区金沙江路 1516 弄",
        },
      ],
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
  methods: {
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
