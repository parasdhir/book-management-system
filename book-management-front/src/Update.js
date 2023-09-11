import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams, useSearchParams } from 'react-router-dom';

function Update() {
    const {id} = useParams(); 
    const [data,setData] = useState([])
    const navigat = useNavigate()
    useEffect(()=>{
        axios.get('http://localhost:8090/book-management-back/editBook/'+id)
        .then(res => setData(res.data) )
        .catch(err  => console.log(err))
    },[])
    function handleSubmit(event){
        event.preventDefault()
        axios.put('http://localhost:8090/book-management-back/updateBook',data)
        .then(res => {
            alert("data updated Succesfully")
            navigat('/')
        })
    }
  return (
    
    <div className="container min-vh-100 d-flex justify-content-center align-items-center mt-4">
        <form onSubmit={handleSubmit}>
        <div>
            <label htmlFor='name'>Name:</label>
            <input type='text' name='name' className='form-control'
            value={data.name}
            onChange={e=>setData({...data,name:e.target.value})}
            />
        </div>
        <div>
            <label htmlFor='author'>Author:</label>
            <input type='text' name='author' className='form-control'
            value={data.author}
            onChange={e=>setData({...data,author:e.target.value})}
            />
        </div>
         <div>
            <label htmlFor='genre'>Genre:</label>
            <input type='text' name='genre' className='form-control'
            value={data.genre}
            onChange={e=>setData({...data,genre:e.target.value})}
            />
        </div>
        <div>
            <label htmlFor='price'>Price:</label>
            <input type='text' name='price' className='form-control'
            value={data.price}
            onChange={e=>setData({...data,price:e.target.value})}
            />
        </div>
        <div>
            <label htmlFor='numberofpages'>Number Of Pages:</label>
            <input type='text' name='numberofpages' className='form-control'
            value={data.numberofpages}
            onChange={e=>setData({...data,numberofpages:e.target.value})}
            />
        </div>
        <div>
            <label htmlFor='rating'>Rating:</label>
            <input type='text' name='rating' className='form-control'
            value={data.rating}
            onChange={e=>setData({...data,rating:e.target.value})}
            />
        </div>
        <button className='btn btn-info'>Update</button>
        </form>
    </div>
    
  )
}

export default Update