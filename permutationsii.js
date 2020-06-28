//Objective is the same as 'Permutations', but this time to only return 
//unique permutations.

let nums = [1,1,2]


//O(N!/(N-k)!) solution that is the same as 'Permutations' but this time we sort
//the array first to skip any of the same elements

nums.sort((a,b) => {
    return a - b
})

let temp = []
let result = []

backtrack(nums, temp)

function backtrack(nums, temp) {
    if (nums.length == 0) {
        result.push([...temp])
        return
    }

    for (let i = 0; i < nums.length; i++){
        if (i !== 0 && nums[i] == nums[i - 1]) {
            continue
        }
        temp.push(nums[i])
        nums.splice(i, 1)
        backtrack(nums, temp)
        nums.splice(i, 0, temp.pop())
    }
}

console.log(result)