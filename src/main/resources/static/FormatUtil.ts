class FormatUtil{
    /**
     * 时间格式化
     * @returns {string}
     */
    public timeFormat():string{
        let date=new Date();
        let month=date.getMonth();
        let hours=date.getHours();
        let minutes=date.getMinutes();
        let seconds=date.getSeconds();
        let seasonNum:number =(date.getMonth()+3)/4;
        let seasonStr:string='';
        switch (seasonNum){
            case 1:
                seasonStr='春';
                break;
            case 2:
                seasonStr='夏';
                break;
            case 3:
                seasonStr='秋';
                break;
            case 4:
                seasonStr='冬';
                break;
        }
        return month+hours+minutes+seconds+'['+seasonStr+']';
    }

    /**
     * 消息格式化
     * @param data
     * @returns {string}
     */
    public messageFormat(data):string{

        let userName= data.userName;
        let message= data.message;

        let msg=this.timeFormat()+userName+'说:'+message+'<br/>';

        return msg;

    }


}