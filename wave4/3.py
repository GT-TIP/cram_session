class Solution:
    # @param {int} n an integer
    # @param {string} str a string with number from 1-n
    #                     in random order and miss one number
    # @return {int} an integer
    def findMissing2(self, n, str):
        # Write your code here
        used = [False for _ in xrange(n + 1)]
        return self.find(n, str, 0, used)

    def find(self, n, str, index, used):
        
        if index == len(str):
            results = []
            for i in xrange(1, n + 1):
                if not used[i]:
                    results.append(i)
            return results[0] if len(results) ==1 else -1

        if str[index] == '0':
            return -1

        for l in xrange(1, 3):
            num = int(str[index : index + l])
            if num >=1 and num <= n and not used[num]:
                used[num] = True
                target = self.find(n, str, index + l, used)
                if target != -1:
                    return target
                used[num] = False

        return -1
