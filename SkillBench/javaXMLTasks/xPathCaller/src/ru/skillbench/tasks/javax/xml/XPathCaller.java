package ru.skillbench.tasks.javax.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * ЦЕЛИ ЗАДАЧИ:<br/>
 * - Разобраться с XPath выражениями: общий синтаксис, абсолютные и относительные пути,
 * оси, фильтры, функции.<br/>
 * - Научиться делать произвольные выборки из древовидных структур с перекрестными ссылками.<br/>
 * - Разобраться с Java XPath API.<br/>
 * <br/>
 * ЗАДАНИЕ<br/>
 * Ознакомиться с двумя XML документами (emp.xml (emp.xsd) и emp-hier.xml).<br/>
 * С помощью XPath сделать выборку элемента (элементов) для каждого пункта задания
 * для каждого из двух документов; XPath для каждого из документов может отличаться.<br/>
 * 1) Для заданного отдела (deptno) выбрать всех сотрудников.<br/>
 * 2) Выбрать имя самого высокооплачиваемого сотрудника.<br/>
 * 3) Для заданного отдела (deptno) выбрать имя самого высокоплачиваемого сотрудника.<br/>
 * 4) Выбрать всех топовых менеджеров (менеджер топовый, если над ним нет менеджера).<br/>
 * 5) Выбрать всех сотрудников, не являющихся менеджерами.<br/>
 * 6) Найти самый затратный отдел (сумма зарплат всех сотрудников самая большая).<br/>
 * 7) Для заданного сотрудника (empno) найти всех коллег, которые в подчинении у того же менеджера.<br/>
 * Во всех методах, возвращающих Element[], должны возвращаться элементы, соответствующие сотрудникам.<br/>
 * Примечание 1: преобразование из Node'ов (NodeList) в Element'ы (Element[]) на практике необходимо для удобства
 * доступа к данным (так что есть смысл научиться писать краткий код для подобных преобразований массивов).<br/>
 * Примечание 2: здесь менеджер - это начальник сотрудника, а не сотрудник с job=MANAGER! <br/>
 * <br/>
 * ТРЕБОВАНИЯ:<br/>
 * - Использовать стандартный XPath API.<br/>
 * - Каждое решение должно содержать только один вызов XPath API с корректным XPath выражением.<br/>
 * - Пространства имен при решении задачи НЕ использовать.<br/>
 *
 * @author Sergey Pankratov
 */
public interface XPathCaller {
    /**
     * Для заданного отдела выбрать всех сотрудников.
     *
     * @param src     XML документ для поиска
     * @param deptno  Номер отдела deptno
     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
     */
    Element[] getEmployees(Document src, String deptno, String docType);

    /**
     * Выбрать имя самого высокооплачиваемого сотрудника.
     *
     * @param src     XML документ для поиска
     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
     */
    String getHighestPayed(Document src, String docType);

    /**
     * Выбрать имя самого высокооплачиваемого сотрудника (любого, если таких несколько).
     *
     * @param src     XML документ для поиска
     * @param deptno  Номер отдела deptno
     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
     */
    String getHighestPayed(Document src, String deptno, String docType);

    /**
     * Выбрать всех топовых менеджеров (менеджер топовый, если над ним нет менеджера)
     *
     * @param src     XML документ для поиска
     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
     */
    Element[] getTopManagement(Document src, String docType);

    /**
     * Выбрать всех сотрудников, не являющихся менеджерами.
     * Считать, что сотрудник не является менеджером, если у него нет подчиненных.
     *
     * @param src     XML документ для поиска
     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
     */
    Element[] getOrdinaryEmployees(Document src, String docType);

    /**
     * Для заданного сотрудника(empno) найти всех коллег, которые в подчинении у того же менеджера.
     *
     * @param src     XML документ для поиска
     * @param empno   Номер сотрудника empno
     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
     */
    Element[] getCoworkers(Document src, String empno, String docType);
}