//
// Autogenerated by Thrift Compiler (0.9.1)
//
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
//


IndexedPageOption = function(args) {
  this.needTotalCount = null;
  this.pageIndex = null;
  this.pageSize = null;
  if (args) {
    if (args.needTotalCount !== undefined) {
      this.needTotalCount = args.needTotalCount;
    }
    if (args.pageIndex !== undefined) {
      this.pageIndex = args.pageIndex;
    }
    if (args.pageSize !== undefined) {
      this.pageSize = args.pageSize;
    }
  }
};
IndexedPageOption.prototype = {};
IndexedPageOption.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.BOOL) {
        this.needTotalCount = input.readBool().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.I32) {
        this.pageIndex = input.readI32().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 3:
      if (ftype == Thrift.Type.I32) {
        this.pageSize = input.readI32().value;
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

IndexedPageOption.prototype.write = function(output) {
  output.writeStructBegin('IndexedPageOption');
  if (this.needTotalCount !== null && this.needTotalCount !== undefined) {
    output.writeFieldBegin('needTotalCount', Thrift.Type.BOOL, 1);
    output.writeBool(this.needTotalCount);
    output.writeFieldEnd();
  }
  if (this.pageIndex !== null && this.pageIndex !== undefined) {
    output.writeFieldBegin('pageIndex', Thrift.Type.I32, 2);
    output.writeI32(this.pageIndex);
    output.writeFieldEnd();
  }
  if (this.pageSize !== null && this.pageSize !== undefined) {
    output.writeFieldBegin('pageSize', Thrift.Type.I32, 3);
    output.writeI32(this.pageSize);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

