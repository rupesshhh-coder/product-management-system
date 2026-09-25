import { useState } from "react"
import { useNavigate } from "react-router-dom";
import { DeleteProductService } from "../Services/ProductService";


export default function DeleteProduct()
{

    const[id,setId]=useState();
    const nav=useNavigate();

    const handleSubmit=(e)=>{
        e.preventDefault();
        DeleteProductService(id)
        .then(()=>{
            nav("/")
        })
        .catch(err=>console.log(err))
    }
    return<>
    
        <h2>Delete</h2>
        <form onSubmit={handleSubmit}>

        Id<input type="text" onChange={(e)=>{setId(e.target.value)}}></input>
        <input type="submit" value="Delete"></input>

        </form>

        </>
}

