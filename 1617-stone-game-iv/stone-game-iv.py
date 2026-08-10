class Solution:
    def winnerSquareGame(self, n: int) -> bool:

        dp = [False] * (n + 1)

        squares = []

        i = 1
        while i * i <= n:
            squares.append(i * i)
            i += 1

        for i in range(1, n + 1):

            for square in squares:

                if square > i:
                    break

                if not dp[i - square]:
                    dp[i] = True
                    break

        return dp[n]