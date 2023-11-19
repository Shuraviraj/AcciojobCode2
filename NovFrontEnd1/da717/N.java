package NovFrontEnd1.da717;

public class N {
    public static void main(String[] args) {
        System.out.println(playSegments(new int[]{1, 1, 0, 1}));
    }

    static int playSegments(int[] segments) {
        int player1Score = 0;
        int player2Score = 0;
        int segmentsToPlay = 0;

        for (int segment : segments) {
            if (segment == 1) {
                player1Score++;
            } else {
                player2Score++;
            }
        }

        // Determine the minimum number of segments Player 1 must play
        for (int i = 0; i < segments.length; i++) {
            if (segments[i] == 0) {
                player1Score++;
            } else {
                player2Score--;
            }

            segmentsToPlay++;

            if (player1Score > player2Score) {
                break;
            }
        }

        return segmentsToPlay;
    }
}
