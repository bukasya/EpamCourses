|               | Ordering | Random Access | Key-Value Pairs | Allows Duplicates | Allows Null Values | Thread Safe | Blocking Operations |
|---------------|----------|---------------|-----------------|-------------------|--------------------|-------------|---------------------|
| ArrayList     |    Yes   |      Yes      |        No       |        Yes        |         Yes        |      No     |          No         |
| Vector        |    Yes   |      Yes      |        No       |        Yes        |         Yes        |     Yes     |         Yes         |
| LinkedList    |    Yes   |      Yes      |        No       |        Yes        |         Yes        |      No     |          No         |
| HashTable     |    No    |       No      |       Yes       |         No        |         No         |     Yes     |          No         |
| HashMap       |    No    |       No      |       Yes       |         No        |         Yes        |      No     |          No         |
| LinkedHashMap |    Yes   |       No      |       Yes       |         No        |         Yes        |      No     |          No         |
| TreeMap       |    Yes   |       No      |       Yes       |         No        |         Yes        |      No     |          No         |
| HashSet       |    No    |       No      |        No       |         No        |         Yes        |      No     |          No         |
| LinkedHashSet |    Yes   |       No      |        No       |         No        |         Yes        |      No     |          No         |
| TreeSet       |    Yes   |       No      |        No       |         No        |         No         |      No     |          No         |