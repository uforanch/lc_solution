public class lc4mediantwosortedarrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int median_index_1 = (nums1.length+nums2.length)/2;
            int median_index_2 = median_index_1;
            if ((nums1.length+nums2.length)%2==0){
                median_index_1--;
            }
            if (nums1.length==0){
                return ((double)nums2[median_index_1] + (double)nums2[median_index_2])/2;
            }
            if (nums2.length==0){
                return ((double)nums1[median_index_1] + (double)nums1[median_index_2])/2;
            }


            int p1 = 0;
            int p2 = 0;
            int current = 0;
            int med1 = 0;
            int med2 = 0;
            for(int i=0;i<median_index_2+1;i++){
                if (p1 >= nums1.length) {
                    current = nums2[p2];
                    p2++;
                }  else if (p2>=nums2.length) {
                    current = nums1[p1];
                    p1++;
                } else {
                    if (nums1[p1]<nums2[p2]){
                        current = nums1[p1];
                        p1++;
                    } else {
                        current = nums2[p2];
                        p2++;
                    }
                }
                if (i==median_index_1){
                    med1 = current;
                }
                if (i==median_index_2){
                    med2 = current;
                }

            }
            return ((double )med1+ (double)med2)/2;
        }
    }
}
