Поиск в матрице (java, IntelliJ IDEA)
1) Решение за O(n + m).

В данном случае мы начинаем поиск из правого верхнего угла и движемся либо вниз, либо влево. Если текущий элемент меньше чем наш искомый элемент, то двигаемся вниз. Если больше, то двигаемся на одну клетку влево.

Создание матрицы и заполнение matrix[i][j] = (N / M * i + j) * 2;

Полученные данные в ходе выполнения 1 алгоритма.

![img.png](Photo/img11.png)

![img.png](Photo/img22.png)


Создание матрицы и заполнение matrix[i][j] = (N / M * i * j) * 2;;

Полученные данные.

![img.png](Photo/img77.png)

![img.png](Photo/img88.png)

Со вторыми данными получилось, что время меньше, чем с первыми.


2) Решение за O(m⋅log(n))

В этом алгоритме проходимся по строкам, выполняя бинарный поиск. В данном случае лучше проходиться по строкам, потому что M <= N.

Создание матрицы и заполнение matrix[i][j] = (N / M * i + j) * 2;

Полученные данные.

![img.png](Photo/img33.png)

![img.png](Photo/img44.png)

Уже на 2 алгоритме видно прирост времени получается, что O(n + m) < O(m*log(n))
Но по данным также видно менее заметное колебание графика.

Создание матрицы и заполнение matrix[i][j] = (N / M * i * j) * 2;

Полученные данные.

![img.png](Photo/img99.png)

![img.png](Photo/img100.png)

Заполняя матрицы вторым вариантом, получили, что появились колебания.

3) Решение за O(m(log(n) - log(m) + 1)) 

В этом алгоритме, находим промежуток строк, где может находиться число, после для каждой строки нужно запустить экспоненциальный поиск.
На первом этапе определяется диапазон, в котором находился бы ключ поиска, если бы он был в списке. На втором этапе выполняется бинарный поиск по этому диапазону.

Создание матрицы и заполнение matrix[i][j] = (N / M * i + j) * 2;

Полученные данные.

![img.png](Photo/img55.png)

![img.png](Photo/img66.png)


Создание матрицы и заполнение matrix[i][j] = (N / M * i * j) * 2;

Полученные данные.

![img.png](Photo/img111.png)

![img.png](Photo/img122.png)

Сравнивая полученные данные на начальных значениях, получаем следующие отношения 

![img.png](Photo/img133.png)

Вывод:
В ходе выполнения лабораторной работы было реализованно 3 алгоритма поиска элемента в отсортированной матрице.
Для каждого алгоритма была создана матрица, которая была заполнена, данными, двумя способами.

Коротко подведём итоги для каждого алгоритма.
1) поиск элемента с продвижением влево, вниз
    В результате получили в среднем одинаковые результаты, расхождения были, но не всегда, в целом алгоритм работает стабильно, 
    что на больших данных, что на малых. По гафику фидно, что он конкурирует с экспоненциальным поиском. Нет сильного прироста по времени.
2) поиск элемента с использованием бинарного поиска
    В ходе выполнения второго алгоритма, получили данные, которые показали, что 2 алгоритм работает дольше чем первый и второй, в основном на больших данных.
    Но в графике присутствуют довольно значительные колебания. На старте при небольших мартицах работал в среднем одинаково с остальными алгоритмами, но при увеличении количества данных, стал дольше работать 
3) поиск элемента с использованием экспоненциального поиска
    Третий алгоритм хорошо работает на больших данный, можно заметить по колебанию линии графика.
    На небольших данных, менее эффективен, превышает по времени, другие алгоритмы. При большом количестве данных обгонял ступенчатый и также наоборот работал медленнее.

![Alt text](Photo/image144.png)

Можно сказать, что для начала решения задачи поиска элемента в матрице, нужно определить с какими данными мы работаем, 
Каждый алгоритм будет работать эффективно в определённых условиях. Лестничный и экспоненциальный хорошо отработали на больших данный, бинарный занял больше времени. На старте при небольших данных все алгоритмы в среденем, работали одинаково.  Первые два алгоритма тоже допустимы и отработают, но уже с большим временем выполнения.
Их лучше использовать для среднего диапазона данных. Эфектиный без резких колебаний был ступенчатый, но экспоненциальный работал тоже хорошо, но с колебаниями.