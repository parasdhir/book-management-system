import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import Navbar from './Navbar';
function App() {

  const [columns,setColumns] = useState([])
  const [records,SetRecords] = useState([])
  const navigate = useNavigate()
  useEffect(()=>{
    axios.get('http://localhost:8090/book-management-back/getBooks')
    .then(res =>{
      setColumns(Object.keys(res.data[0]))
      SetRecords(res.data)
    })
  },{})
  return (
  
    <div className="container mt-5">
         <Navbar/>

      
      <table className ="table table-striped table-dark mt-4">
        <thead>
          <tr>
            {columns.map((c, i) =>
              c === 'numberofpages' ? (
                <th scope="col" key={i}>Number Of Pages</th>
              ) : (
                <th scope="col" className='capitalize' key={i}>{c.charAt(0).toUpperCase() + c.slice(1)}</th>
              )
            )}
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {
          records.map((d,i) => (
            <tr key={i}>
              <th scope="row">{d.id}</th>
            <td>{d.name}</td>
            <td>{d.author}</td>
            <td>{d.genre}</td>
            <td>{d.numberofpages}</td>
            <td>{d.price}</td>
            <td>{d.rating}/5</td>
            <td><Link to={`/update/${d.id}`} className="btn btn-warning mr-4">Update</Link>
            <button onClick={e=>handleDelete(d.id)} className="btn btn-danger">delete</button>
            </td>
            </tr>
          ))
          }
          
        </tbody>
      </table>
    </div>
  );

  function handleDelete(id){
    const conf = window.confirm("Do you really want to delete");
    if(conf){
      axios.delete("http://localhost:8090/book-management-back/deleteBook/"+id)
      .then(res =>{
        alert("record deleted successfully")
        window.location.reload()
        
      }).catch(err => console.log(err))

    }
  }
}

export default App;
