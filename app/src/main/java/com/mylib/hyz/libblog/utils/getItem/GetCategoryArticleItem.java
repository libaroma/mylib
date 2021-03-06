package com.mylib.hyz.libblog.utils.getItem;

import java.util.List;

public class GetCategoryArticleItem {

    /**
     * success : true
     * code : 2019
     * message : 获取文章列表成功！
     * data : {"content":[{"id":"816995205814157312","title":"博客数据表","userId":"766394825724395520","categoryId":"816468026143539200","type":"2","state":"1","coverImg":"/portal/image/get/XH*&&*1613376732860_810906321120395264.png?mode=scale&scale=0.5","summary":"博客数据表思维导图","labels":"博客-数据表结构-思维导图","viewCount":10,"publishTime":1614828436103,"updateTime":1614828436103,"labelArr":["博客","数据表结构","思维导图"]}],"pageable":{"sort":{"sorted":true,"unsorted":false},"pageSize":10,"pageNumber":0,"offset":0,"unpaged":false,"paged":true},"totalPages":1,"totalElements":1,"last":true,"first":true,"sort":{"sorted":true,"unsorted":false},"numberOfElements":1,"size":10,"number":0}
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
         * content : [{"id":"816995205814157312","title":"博客数据表","userId":"766394825724395520","categoryId":"816468026143539200","type":"2","state":"1","coverImg":"/portal/image/get/XH*&&*1613376732860_810906321120395264.png?mode=scale&scale=0.5","summary":"博客数据表思维导图","labels":"博客-数据表结构-思维导图","viewCount":10,"publishTime":1614828436103,"updateTime":1614828436103,"labelArr":["博客","数据表结构","思维导图"]}]
         * pageable : {"sort":{"sorted":true,"unsorted":false},"pageSize":10,"pageNumber":0,"offset":0,"unpaged":false,"paged":true}
         * totalPages : 1
         * totalElements : 1
         * last : true
         * first : true
         * sort : {"sorted":true,"unsorted":false}
         * numberOfElements : 1
         * size : 10
         * number : 0
         */

        private PageableBean pageable;
        private int totalPages;
        private int totalElements;
        private boolean last;
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

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
        }

        public boolean isLast() {
            return last;
        }

        public void setLast(boolean last) {
            this.last = last;
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
             * pageSize : 10
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
