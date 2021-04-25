//
// Autogenerated by Thrift Compiler (0.9.1)
//
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
//


OperateResult = function(args) {
  this.success = null;
  this.code = null;
  this.message = null;
  if (args) {
    if (args.success !== undefined) {
      this.success = args.success;
    }
    if (args.code !== undefined) {
      this.code = args.code;
    }
    if (args.message !== undefined) {
      this.message = args.message;
    }
  }
};
OperateResult.prototype = {};
OperateResult.prototype.read = function(input) {
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
        this.success = input.readBool().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.I32) {
        this.code = input.readI32().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 3:
      if (ftype == Thrift.Type.STRING) {
        this.message = input.readString().value;
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

OperateResult.prototype.write = function(output) {
  output.writeStructBegin('OperateResult');
  if (this.success !== null && this.success !== undefined) {
    output.writeFieldBegin('success', Thrift.Type.BOOL, 1);
    output.writeBool(this.success);
    output.writeFieldEnd();
  }
  if (this.code !== null && this.code !== undefined) {
    output.writeFieldBegin('code', Thrift.Type.I32, 2);
    output.writeI32(this.code);
    output.writeFieldEnd();
  }
  if (this.message !== null && this.message !== undefined) {
    output.writeFieldBegin('message', Thrift.Type.STRING, 3);
    output.writeString(this.message);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

CompanyReceiver = function(args) {
  this.companyId = null;
  this.companyCode = null;
  this.companyName = null;
  if (args) {
    if (args.companyId !== undefined) {
      this.companyId = args.companyId;
    }
    if (args.companyCode !== undefined) {
      this.companyCode = args.companyCode;
    }
    if (args.companyName !== undefined) {
      this.companyName = args.companyName;
    }
  }
};
CompanyReceiver.prototype = {};
CompanyReceiver.prototype.read = function(input) {
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
      if (ftype == Thrift.Type.I64) {
        this.companyId = input.readI64().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRING) {
        this.companyCode = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 3:
      if (ftype == Thrift.Type.STRING) {
        this.companyName = input.readString().value;
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

CompanyReceiver.prototype.write = function(output) {
  output.writeStructBegin('CompanyReceiver');
  if (this.companyId !== null && this.companyId !== undefined) {
    output.writeFieldBegin('companyId', Thrift.Type.I64, 1);
    output.writeI64(this.companyId);
    output.writeFieldEnd();
  }
  if (this.companyCode !== null && this.companyCode !== undefined) {
    output.writeFieldBegin('companyCode', Thrift.Type.STRING, 2);
    output.writeString(this.companyCode);
    output.writeFieldEnd();
  }
  if (this.companyName !== null && this.companyName !== undefined) {
    output.writeFieldBegin('companyName', Thrift.Type.STRING, 3);
    output.writeString(this.companyName);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

GroupReceiver = function(args) {
  this.groupId = null;
  this.groupCode = null;
  this.groupName = null;
  this.companyId = null;
  if (args) {
    if (args.groupId !== undefined) {
      this.groupId = args.groupId;
    }
    if (args.groupCode !== undefined) {
      this.groupCode = args.groupCode;
    }
    if (args.groupName !== undefined) {
      this.groupName = args.groupName;
    }
    if (args.companyId !== undefined) {
      this.companyId = args.companyId;
    }
  }
};
GroupReceiver.prototype = {};
GroupReceiver.prototype.read = function(input) {
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
      if (ftype == Thrift.Type.I64) {
        this.groupId = input.readI64().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRING) {
        this.groupCode = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 3:
      if (ftype == Thrift.Type.STRING) {
        this.groupName = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 4:
      if (ftype == Thrift.Type.I64) {
        this.companyId = input.readI64().value;
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

GroupReceiver.prototype.write = function(output) {
  output.writeStructBegin('GroupReceiver');
  if (this.groupId !== null && this.groupId !== undefined) {
    output.writeFieldBegin('groupId', Thrift.Type.I64, 1);
    output.writeI64(this.groupId);
    output.writeFieldEnd();
  }
  if (this.groupCode !== null && this.groupCode !== undefined) {
    output.writeFieldBegin('groupCode', Thrift.Type.STRING, 2);
    output.writeString(this.groupCode);
    output.writeFieldEnd();
  }
  if (this.groupName !== null && this.groupName !== undefined) {
    output.writeFieldBegin('groupName', Thrift.Type.STRING, 3);
    output.writeString(this.groupName);
    output.writeFieldEnd();
  }
  if (this.companyId !== null && this.companyId !== undefined) {
    output.writeFieldBegin('companyId', Thrift.Type.I64, 4);
    output.writeI64(this.companyId);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

ContentText = function(args) {
  this.fileName = null;
  this.contentText = null;
  if (args) {
    if (args.fileName !== undefined) {
      this.fileName = args.fileName;
    }
    if (args.contentText !== undefined) {
      this.contentText = args.contentText;
    }
  }
};
ContentText.prototype = {};
ContentText.prototype.read = function(input) {
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
      if (ftype == Thrift.Type.STRING) {
        this.fileName = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRING) {
        this.contentText = input.readString().value;
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

ContentText.prototype.write = function(output) {
  output.writeStructBegin('ContentText');
  if (this.fileName !== null && this.fileName !== undefined) {
    output.writeFieldBegin('fileName', Thrift.Type.STRING, 1);
    output.writeString(this.fileName);
    output.writeFieldEnd();
  }
  if (this.contentText !== null && this.contentText !== undefined) {
    output.writeFieldBegin('contentText', Thrift.Type.STRING, 2);
    output.writeString(this.contentText);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

MBMessageTemplateSelector = function(args) {
  this.templateId = null;
  this.templateName = null;
  if (args) {
    if (args.templateId !== undefined) {
      this.templateId = args.templateId;
    }
    if (args.templateName !== undefined) {
      this.templateName = args.templateName;
    }
  }
};
MBMessageTemplateSelector.prototype = {};
MBMessageTemplateSelector.prototype.read = function(input) {
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
      if (ftype == Thrift.Type.I64) {
        this.templateId = input.readI64().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRING) {
        this.templateName = input.readString().value;
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

MBMessageTemplateSelector.prototype.write = function(output) {
  output.writeStructBegin('MBMessageTemplateSelector');
  if (this.templateId !== null && this.templateId !== undefined) {
    output.writeFieldBegin('templateId', Thrift.Type.I64, 1);
    output.writeI64(this.templateId);
    output.writeFieldEnd();
  }
  if (this.templateName !== null && this.templateName !== undefined) {
    output.writeFieldBegin('templateName', Thrift.Type.STRING, 2);
    output.writeString(this.templateName);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

