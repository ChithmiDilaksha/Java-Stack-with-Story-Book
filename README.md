# Java-Stack-with-Story-Book

# Browser History GUI

This Java application simulates a simple browser history using Swing GUI components. It allows users to navigate through a predefined story using back, forward, and next buttons.

## Features

- Navigate through pages of a story.
- Implement back and forward functionalities using stacks.
- Simple graphical user interface using Java Swing.

    
## codes

1. BrowserHistoryGUI  Class
   ```sh
   import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrowserHistoryGUI extends JFrame {
    private Stack backStack;
    private Stack forwardStack;
    private String currentPage;
    private JTextArea storyTextArea;
    private JLabel pageNumberLabel;
    private JButton nextButton;
    private JButton backButton;
    private JButton forwardButton;
    private JButton exitButton;

    private String[] storyPages = {
            "Once upon a time, there was a kind and gentle girl named Cinderella. She lived with her wicked stepmother and two cruel stepsisters who made her do all the chores and treated her terribly.",
            "One day, an invitation arrived for a grand ball at the palace. The prince was looking for a bride, and every eligible maiden was invited. Cinderella's stepmother and stepsisters went to the ball, leaving her behind.",
            "As Cinderella wept, her Fairy Godmother appeared. With a wave of her wand, she transformed a pumpkin into a magnificent coach, mice into horses, and rags into a beautiful gown with glass slippers. But there was one condition: Cinderella had to return before midnight, as the magic would wear off.",
            "At the ball, Cinderella captivated everyone, especially the prince. They danced all night, but as the clock struck midnight, Cinderella fled, leaving behind one glass slipper.",
            "The prince searched the kingdom for the girl who fit the slipper. When he arrived at Cinderella's house, her stepsisters tried to fit into the slipper, but it was no use. Finally, Cinderella tried it on, and it fit perfectly.",
            "The prince and Cinderella were overjoyed. They were soon married, and Cinderella's kindness was rewarded. She and the prince lived happily ever after."
    };
    private int currentPageIndex;

    public BrowserHistoryGUI() {
        backStack = new Stack();
        forwardStack = new Stack();
        currentPage = null;
        currentPageIndex = -1;

        setTitle("Cinder Ella story");
        setSize(450, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel(new FlowLayout());
        nextButton = new JButton("Next");
        backButton = new JButton("Back");
        forwardButton = new JButton("Forward");
        exitButton = new JButton("Exit");

        bottomPanel.add(nextButton);
        bottomPanel.add(backButton);
        bottomPanel.add(forwardButton);
        bottomPanel.add(exitButton);

        add(bottomPanel, BorderLayout.SOUTH);

        storyTextArea = new JTextArea();
        storyTextArea.setFont(new Font("Serif", Font.PLAIN, 28)); // Adjust the font size here
        storyTextArea.setLineWrap(true);
        storyTextArea.setWrapStyleWord(true);
        storyTextArea.setEditable(false);
        add(new JScrollPane(storyTextArea), BorderLayout.CENTER);

        pageNumberLabel = new JLabel("Page: 0");
        pageNumberLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Adjust the font size here
        pageNumberLabel.setForeground(Color.RED); // Set the font color to red
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(pageNumberLabel, BorderLayout.NORTH);
        add(topPanel, BorderLayout.NORTH);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visitNextPage();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBack();
            }
        });

        forwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goForward();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });

        setVisible(true);
    }

    private void visitNextPage() {
        if (currentPageIndex < storyPages.length - 1) {
            if (currentPage != null) {
                backStack.push(currentPage);
            }
            currentPageIndex++;
            currentPage = storyPages[currentPageIndex];
            forwardStack.clear(); // Clear forward history
            updateCurrentPage();
        }
    }

    private void goBack() {
        if (backStack.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No previous page.");
        } else {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
            currentPageIndex--;
            updateCurrentPage();
        }
    }

    private void goForward() {
        if (forwardStack.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No next page.");
        } else {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
            currentPageIndex++;
            updateCurrentPage();
        }
    }

    private void updateCurrentPage() {
        storyTextArea.setText(currentPage);
        pageNumberLabel.setText("Page: " + (currentPageIndex + 1));
    }

    private void exit() {
        System.out.println("Exiting browser history manager.");
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BrowserHistoryGUI();
            }
        });
    }
}

2. Stack Class
   ```sh
   public class Stack {
    private StackNode top;

    public Stack() {
        this.top = null;
    }

    public void push(String data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (top == null) {
            return null;
        }
        String data = top.data;
        top = top.next;
        return data;
    }

    public String peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void clear() {
        top = null;
    }
}

3. Stack Class
   ```sh
   class StackNode {
    String data;
    StackNode next;

    StackNode(String data) {
        this.data = data;
        this.next = null;
    }
}

# output 
![Screenshot (74)](https://github.com/ChithmiDilaksha/Java-Stack-with-Story-Book/assets/148516815/aa8a0ddb-0708-4ab3-b672-fe2de23ffa23)
![Screenshot (75)](https://github.com/ChithmiDilaksha/Java-Stack-with-Story-Book/assets/148516815/361589f9-6943-4a45-946c-65ad39fe2dc8)
![Screenshot (76)](https://github.com/ChithmiDilaksha/Java-Stack-with-Story-Book/assets/148516815/3d824119-5f1f-4fd7-9708-d67df3f55c6e)
![Screenshot (77)](https://github.com/ChithmiDilaksha/Java-Stack-with-Story-Book/assets/148516815/79d3f9eb-668c-48f5-bd05-587fae7d93d1)
![Screenshot (78)](https://github.com/ChithmiDilaksha/Java-Stack-with-Story-Book/assets/148516815/59a2ba7e-b902-4cb7-adbf-dc56ed27aabf)
