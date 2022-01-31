package question1;

public class PatternObservateur extends junit.framework.TestCase {

    public void testNotify() {
        ConcreteSubject list;
        ConcreteObserver observer;

        list = new ConcreteSubject();   
        observer = new ConcreteObserver();   
        list.addObserver(observer);    
        list.insert("il fait beau, ce matin");
                                  
        assertFalse(observer.senders().empty());                           
        assertEquals(list, observer.senders().pop());                       
        assertEquals("il fait beau, ce matin", observer.arguments().pop()); 
    }

    public void test1() {
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        question1.ConcreteObserver o1 = new question1.ConcreteObserver();
        question1.ConcreteObserver o2 = new question1.ConcreteObserver();
        l1.addObserver(o1);
        l1.addObserver(o2);
        l1.insert("test");
        l1.insert(" 1 ");
        
        assertFalse(o1.senders().empty()); 
        assertFalse(o2.senders().empty()); 
        
        assertEquals(l1, o1.senders().pop());
        assertEquals(l1, o2.senders().pop());
        
        assertEquals(" 1 ", o1.arguments().pop());
        assertEquals("test", o1.arguments().pop());
        assertEquals(" 1 ", o2.arguments().pop());
        assertEquals("test", o2.arguments().pop());
        
        o1.senders().pop();
        o2.senders().pop();
        
        assertTrue(o1.senders().empty() && o1.arguments().empty());
        assertTrue(o2.senders().empty() && o2.arguments().empty());
    }

    public void test2() {
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        question1.ConcreteSubject l2 = new question1.ConcreteSubject();

        question1.ConcreteObserver o = new question1.ConcreteObserver();
        l1.addObserver(o);
        l2.addObserver(o);
        l1.insert("testA");
        l1.insert(" A ");
        l2.insert("testB");
        l2.insert(" B ");

        assertFalse(o.senders().empty()); 
        
        assertEquals(l2, o.senders().pop());
        assertEquals(l2, o.senders().pop());
        assertEquals(l1, o.senders().pop());
        assertEquals(l1, o.senders().pop());
        
        assertEquals(" B ", o.arguments().pop());
        assertEquals("testB", o.arguments().pop());
        assertEquals(" A ", o.arguments().pop());
        assertEquals("testA", o.arguments().pop());

        assertTrue(o.senders().empty() && o.arguments().empty());
    }

    public void test3() {
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        question1.ConcreteSubject l2 = new question1.ConcreteSubject();
        question1.ConcreteObserver o1 = new question1.ConcreteObserver();
        question1.ConcreteObserver o2 = new question1.ConcreteObserver();
        l1.addObserver(o1);
        l1.addObserver(o2);
        l2.addObserver(o1);
        l2.addObserver(o2);

        assertTrue(l1.countObservers() == 2);
        assertTrue(l2.countObservers() == 2);
        
        l1.deleteObserver(o1);
        assertTrue(l1.countObservers() == 1);
        
        l2.deleteObserver(o1);
        assertTrue(l2.countObservers() == 1);
        
        l1.deleteObservers();
        l2.deleteObservers();

        assertTrue(o1.senders().empty());
        assertTrue(o2.senders().empty());
        assertTrue(l1.countObservers() == 0);
        assertTrue(l2.countObservers() == 0);
    }
    
}