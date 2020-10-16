
var a = [2,2,4,7,11,12,67];
var b = [1,1,1,1,3,5,6,123];//[1,2,4,7,11,12,67];
let k = 5;

function kth(a,b,k){
    var i = Math.floor(k/2)-1;
    var j = k-i-2;
    var count = Math.floor(k/4);
    console.log(i + ", "+ j +", count = " + count);
    console.log(a[i] + "= a, b = "+ b[j] +", count = " + count);
    while(count > 0){
        if(i === k || j === k){
            break;
        }
        console.log(i + ", "+ j);
        if(a[i+1] <= b[j]){
            console.log("a <= b" + i + ", "+ j);
            i++;
            j--;

        }else{
            console.log("a > b" + i + ", "+ j);
            i--;
            j++;
        }
        count = Math.floor(count/2);
    }

    if(a[i] > b[j]) {
        return "ii = " + a[i];
    }else {
        return "j = " + b[j];
    }

}
console.log(kth(a,b,k));