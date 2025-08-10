import { useEffect, useState } from 'react';

export default function App(){
  const [events, setEvents] = useState([]);

  useEffect(()=>{
    const es = new EventSource('http://localhost:5174/api/products/events');

    es.onmessage = (e) => {
      try {
        const payload = JSON.parse(e.data);
        setEvents(prev => [payload, ...prev].slice(0, 50));
      } catch(err){
        console.error('invalid event', err);
      }
    }

    es.onerror = (err) => {
      console.error('EventSource failed', err);
      es.close();
    }

    return () => es.close();
  }, []);

  return (
    <div style={{padding:20}}>
      <h1>Live Price Updates</h1>
      <ul>
        {events.map((ev, idx) => (
          <li key={idx}>
            <strong>{ev.productName}</strong> — ₹{ev.price} <em>({new Date(ev.timestamp).toLocaleTimeString()})</em>
          </li>
        ))}
      </ul>
    </div>
  );
}