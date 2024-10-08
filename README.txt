

1) deleteSubsection
- Pseudocode:
function deleteSubsection(lower, upper):
1;95;0c    if head is null:
        return // List is empty

    leftRemoval = head
    rightRemoval = head

    // Traverse list to find the first element greater than or equal to lower
    while leftRemoval is not null and leftRemoval.info < lower:
        leftRemoval = leftRemoval.next

    // Traverse list to find the last element less than or equal to upper
    while rightRemoval is not null and rightRemoval.info <= upper:
        rightRemoval = rightRemoval.next

    if leftRemoval == null or rightRemoval == null:
        return // No nodes within the range

    // Adjust pointers to remove the subsection
    if leftRemoval.back is not null:
        leftRemoval.back.next = rightRemoval
    if rightRemoval is not null:
        rightRemoval.back = leftRemoval.back
    if leftRemoval == head:
        head = rightRemoval

- Complexity:
    Time Complexity: O(n)
    Space Complexity: O(1)

2) reverseList()
- Pseudocode:
function reverseList():
    current = head
    prev = null

    // Traverse the list and swap next and back pointers
    while current is not null:
        temp = current.back
        current.back = current.next
        current.next = temp
        prev = current
        current = current.back

    // Update head to be the new head of the reversed list
    head = prev

- Complexity:
    Time Complexity: O(n)
    Space Complexity: O(1)

3) swapAlternate
- Pseudocode:
function swapAlternate():
    current = head

    // Traverse the list two nodes at a time
    while current is not null and current.next is not null:
        nextNode = current.next

        // Adjust the links to swap current and nextNode
        if current.back is not null:
            current.back.next = nextNode
        nextNode.back = current.back

        current.next = nextNode.next
        if nextNode.next is not null:
            nextNode.next.back = current

        nextNode.next = current
        current.back = nextNode

        // Move to the next pair
        current = current.next

- Complexity:
    Time Complexity: O(n)
    Space Complexity: O(1)

Running the code:

    javac -d bin src/NodeType.java
    javac -d bin -cp bin src/DoublyLinkedList.java
    javac -d bin -cp bin src/DoublyLinkedListDriver.java
    java -cp bin DoublyLinkedListDriver [Location of file to use]

    OR

    Use the compile_and_run.sh script to use int-input.txt as the argument

Credit:
    NodeType.java - Jackson Bell
    DoublyLinkedList.java - Hiep Pham and Jackson Bell (Commenting and debugging)
    DoublyLinkedListDriver - Jackson Bell and Hiep Pham (Debugging)

Submission:
    Jackson Bell - jrb57375@uga.edu
    Hiep Pham - hhp48004@uga.edu
