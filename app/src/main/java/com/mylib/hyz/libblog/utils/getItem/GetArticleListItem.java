package com.mylib.hyz.libblog.utils.getItem;

import java.util.List;

public class GetArticleListItem {

    /**
     * success : true
     * code : 2019
     * message : 获取文章列表成功！
     * data : {"content":[{"id":"816995205814157312","title":"博客数据表","userId":"766394825724395520","categoryId":"816468026143539200","type":"2","state":"1","coverImg":"/portal/image/get/XH*&&*1613376732860_810906321120395264.png?mode=scale&scale=0.5","summary":"博客数据表思维导图","labels":"博客-数据表结构-思维导图","viewCount":10,"publishTime":1614828436103,"updateTime":1614828436103,"labelArr":["博客","数据表结构","思维导图"]},{"id":"816052404985266176","title":"《撒野》罗曼·耶卓","userId":"766394825724395520","categoryId":"810976279321903104","type":"1","state":"1","coverImg":"/portal/image/get/XH*&&*1614603597944_816052166786547712.png","summary":"《撒野》钢琴还原","labels":"罗曼·耶卓-钢琴-撒野","viewCount":10,"publishTime":1614603654869,"updateTime":1614603654869,"labelArr":["罗曼·耶卓","钢琴","撒野"]},{"id":"811628786293407744","title":"今日份日记","userId":"766394825724395520","categoryId":"811628973199982592","type":"1","state":"1","coverImg":"/portal/image/get/XH*&&*1614827138230_816989762320596992.png","summary":"12.19今日份日记","labels":"日记-小诗","viewCount":14,"publishTime":1613548981986,"updateTime":1614828853132,"labelArr":["日记","小诗"]},{"id":"810952874694541312","title":"看烟花咯","userId":"766394825724395520","categoryId":"810976279321903104","type":"1","state":"1","coverImg":"/portal/image/get/XH*&&*1613230737902_810293975301750784.png","summary":"视频测试。","labels":"视频-测试","viewCount":40,"publishTime":1613387832103,"updateTime":1613393446108,"labelArr":["视频","测试"]}],"pageable":{"sort":{"sorted":true,"unsorted":false},"pageSize":5,"pageNumber":0,"offset":0,"unpaged":false,"paged":true},"last":true,"totalElements":4,"totalPages":1,"first":true,"sort":{"sorted":true,"unsorted":false},"numberOfElements":4,"size":5,"number":0}
     */

    private boolean success;
    private int code;
    private String message;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * content : [{"id":"816995205814157312","title":"博客数据表","userId":"766394825724395520","categoryId":"816468026143539200","type":"2","state":"1","coverImg":"/portal/image/get/XH*&&*1613376732860_810906321120395264.png?mode=scale&scale=0.5","summary":"博客数据表思维导图","labels":"博客-数据表结构-思维导图","viewCount":10,"publishTime":1614828436103,"updateTime":1614828436103,"labelArr":["博客","数据表结构","思维导图"]},{"id":"816052404985266176","title":"《撒野》罗曼·耶卓","userId":"766394825724395520","categoryId":"810976279321903104","type":"1","state":"1","coverImg":"/portal/image/get/XH*&&*1614603597944_816052166786547712.png","summary":"《撒野》钢琴还原","labels":"罗曼·耶卓-钢琴-撒野","viewCount":10,"publishTime":1614603654869,"updateTime":1614603654869,"labelArr":["罗曼·耶卓","钢琴","撒野"]},{"id":"811628786293407744","title":"今日份日记","userId":"766394825724395520","categoryId":"811628973199982592","type":"1","state":"1","coverImg":"/portal/image/get/XH*&&*1614827138230_816989762320596992.png","summary":"12.19今日份日记","labels":"日记-小诗","viewCount":14,"publishTime":1613548981986,"updateTime":1614828853132,"labelArr":["日记","小诗"]},{"id":"810952874694541312","title":"看烟花咯","userId":"766394825724395520","categoryId":"810976279321903104","type":"1","state":"1","coverImg":"/portal/image/get/XH*&&*1613230737902_810293975301750784.png","summary":"视频测试。","labels":"视频-测试","viewCount":40,"publishTime":1613387832103,"updateTime":1613393446108,"labelArr":["视频","测试"]}]
         * pageable : {"sort":{"sorted":true,"unsorted":false},"pageSize":5,"pageNumber":0,"offset":0,"unpaged":false,"paged":true}
         * last : true
         * totalElements : 4
         * totalPages : 1
         * first : true
         * sort : {"sorted":true,"unsorted":false}
         * numberOfElements : 4
         * size : 5
         * number : 0
         */

        private PageableBean pageable;
        private boolean last;
        private int totalElements;
        private int totalPages;
        private boolean first;
        private SortBeanX sort;
        private int numberOfElements;
        private int size;
        private int number;
        private List<ContentBean> content;

        public PageableBean getPageable() {
            return pageable;
        }

        public void setPageable(PageableBean pageable) {
            this.pageable = pageable;
        }

        public boolean isLast() {
            return last;
        }

        public void setLast(boolean last) {
            this.last = last;
        }

        public int getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public boolean isFirst() {
            return first;
        }

        public void setFirst(boolean first) {
            this.first = first;
        }

        public SortBeanX getSort() {
            return sort;
        }

        public void setSort(SortBeanX sort) {
            this.sort = sort;
        }

        public int getNumberOfElements() {
            return numberOfElements;
        }

        public void setNumberOfElements(int numberOfElements) {
            this.numberOfElements = numberOfElements;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public List<ContentBean> getContent() {
            return content;
        }

        public void setContent(List<ContentBean> content) {
            this.content = content;
        }

        public static class PageableBean {
            /**
             * sort : {"sorted":true,"unsorted":false}
             * pageSize : 5
             * pageNumber : 0
             * offset : 0
             * unpaged : false
             * paged : true
             */

            private SortBean sort;
            private int pageSize;
            private int pageNumber;
            private int offset;
            private boolean unpaged;
            private boolean paged;

            public SortBean getSort() {
                return sort;
            }

            public void setSort(SortBean sort) {
                this.sort = sort;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getPageNumber() {
                return pageNumber;
            }

            public void setPageNumber(int pageNumber) {
                this.pageNumber = pageNumber;
            }

            public int getOffset() {
                return offset;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }

            public boolean isUnpaged() {
                return unpaged;
            }

            public void setUnpaged(boolean unpaged) {
                this.unpaged = unpaged;
            }

            public boolean isPaged() {
                return paged;
            }

            public void setPaged(boolean paged) {
                this.paged = paged;
            }

            public static class SortBean {
                /**
                 * sorted : true
                 * unsorted : false
                 */

                private boolean sorted;
                private boolean unsorted;

                public boolean isSorted() {
                    return sorted;
                }

                public void setSorted(boolean sorted) {
                    this.sorted = sorted;
                }

                public boolean isUnsorted() {
                    return unsorted;
                }

                public void setUnsorted(boolean unsorted) {
                    this.unsorted = unsorted;
                }
            }
        }

        public static class SortBeanX {
            /**
             * sorted : true
             * unsorted : false
             */

            private boolean sorted;
            private boolean unsorted;

            public boolean isSorted() {
                return sorted;
            }

            public void setSorted(boolean sorted) {
                this.sorted = sorted;
            }

            public boolean isUnsorted() {
                return unsorted;
            }

            public void setUnsorted(boolean unsorted) {
                this.unsorted = unsorted;
            }
        }

        public static class ContentBean extends GetArticleItem {
        }
    }
}
