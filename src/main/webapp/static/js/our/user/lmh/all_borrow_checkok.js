var allCheckok = {
    id: {
        priTabId: 'borrow-checkok-list',
        searchFormId: 'checkok-search-form',
        hkbListId: 'hkb-list',
        hkbModalId: 'hkb-modal'
    },
    formatter: {
        formatState: function (value) {
            if (value === 1) {
                return '融资中';
            } else if (value === 4) {
                return '还款中';
            } else if (value === 5) {
                return '融资失败';
            } else if (value === 6) {
                return '还款成功';
            }
        }
    },
    submitForm: {
        search: function (select) {
            if (select.value === '-1') {
                setTable.postRefresh(allCheckok.id.priTabId);
            } else {
                setTable.doSearch(allCheckok.id.searchFormId,
                    allCheckok.id.priTabId,
                    contextPath + '/borrowapply/list_checkok');
            }
        }
    },
    look: {
        hkbList: function () {
            var row = setTable.isSingleSelected(allCheckok.id.priTabId);
            if (row) {
                var hkbTable = $('#' + allCheckok.id.hkbListId);
                var url = hkbTable.attr('data-url');
                hkbTable.attr('data-url', url + '?baid=' + row.baid);
                $('#' + allCheckok.id.hkbListId).bootstrapTable({
                    method: 'get',
                    contentType: 'application/x-www-form-urlencoded',
                    //【其它设置】
                    locale: 'zh-CN',//中文支持
                    pagination: true,//是否开启分页（*）
                    sidePagination: 'server', //分页方式：client客户端分页，server服务端分页（*）
                    showRefresh: true,//刷新按钮
                    height: $(window).height()//table的高度
                });
                setTable.showModal(allCheckok.id.hkbModalId);
            }
        }
    }
};