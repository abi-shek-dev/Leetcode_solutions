from functools import cache

class Solution:
    def stoneGameIII(self, stoneValue):

        n = len(stoneValue)

        @cache
        def dp(i):

            if i >= n:
                return 0

            best = float("-inf")
            total = 0

            for k in range(3):

                if i + k < n:

                    total += stoneValue[i + k]

                    best = max(
                        best,
                        total - dp(i + k + 1)
                    )

            return best

        diff = dp(0)

        if diff > 0:
            return "Alice"

        elif diff < 0:
            return "Bob"

        return "Tie"