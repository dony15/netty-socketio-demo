var FormatUtil = /** @class */ (function () {
    function FormatUtil() {
    }
    /**
     * 时间格式化
     * @returns {string}
     */
    FormatUtil.prototype.timeFormat = function () {
        var date = new Date();
        var month = date.getMonth();
        var hours = date.getHours();
        var minutes = date.getMinutes();
        var seconds = date.getSeconds();
        var seasonNum = (date.getMonth() + 3) / 4;
        var seasonStr = '';
        switch (seasonNum) {
            case 1:
                seasonStr = '春';
                break;
            case 2:
                seasonStr = '夏';
                break;
            case 3:
                seasonStr = '秋';
                break;
            case 4:
                seasonStr = '冬';
                break;
        }
        return month + hours + minutes + seconds + '[' + seasonStr + ']';
    };
    /**
     * 消息格式化
     * @param data
     * @returns {string}
     */
    FormatUtil.prototype.messageFormat = function (data) {
        var userName = data.userName;
        var message = data.message;
        var msg = this.timeFormat() + userName + '说:' + message + '<br/>';
        return msg;
    };
    return FormatUtil;
}());
