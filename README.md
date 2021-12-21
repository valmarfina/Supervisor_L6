# Supervisor_L6(Лабораторная 6)


Создать супервизор (управляющую программу), которая контролирует исполнение абстрактной программы.
* Абстрактная программа работает в отдельном потоке и является классом с полем перечисляемого типа, который отражает ее состояние (UNKNOWN, STOPPING, RUNNING, FATAL ERROR) и имеет потокдемон случайного состояния, который в заданном интервале меняет её состояние на случайное.
* У супервизора должны быть методы остановки и запуска абстрактной программы, которые меняют ее состояние.
* Супервизор является потоком, который циклически опрашивает абстрактную программу, и если ее состояние UNKNOWN или STOPPING, то перезапускает ее.
* Если состояние FATAL ERROR, то работа абстрактной программы завершается супервизором.
* Все изменения состояний должны сопровождаться соответствующими сообщениями в консоли.
* Использовать конструкции с wait/notify

_____________

Create a supervisor (control program) that controls the execution of the abstract program.
* The abstract program runs in a separate thread and is a class with a field of enumerated type that reflects its state (UNKNOWN, STOPPING, RUNNING, FATAL ERROR) and has a random state thread that changes its state to random in a given interval.
* The supervisor must have methods for stopping and starting the abstract program which change its state.
* The supervisor is a thread which cyclically polls the abstract program, and if its state is UNKNOWN or STOPPING, it restarts it.
* If the state is FATAL ERROR, the abstract program is terminated by the supervisor.
* All changes of states must be accompanied by corresponding messages in the console.
* Use constructions with wait/notify
