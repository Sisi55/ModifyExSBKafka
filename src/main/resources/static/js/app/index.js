var index = {
    init: function () {
        var _this = this;
        $('#btn-click').on('click', function () {
            var data = {
                userName: "sisi",
                actionType: "click"
            };
            $.ajax({
                type: 'POST',
                url: '/v1/ubicshop',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            });
            window.location.href = '/';

        });
        $('#btn-shoplist').on('click', function () {
            var data = {
                userName: "sisi",
                actionType: "shoplist"
            };
            $.ajax({
                type: 'POST',
                url: '/v1/ubicshop',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            });
            window.location.href = '/';

        });
    }
};
index.init();