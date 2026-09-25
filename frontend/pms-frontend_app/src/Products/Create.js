
import axios from "axios";
import { useState } from "react";

export default function CreateProduct()
{

    const[id,setId]=useState();
    const[name,setName]=useState();
    const[category,setCategory]=useState();
    const[cost,setCost]=useState();
    const[qty,setQty]=useState();

    const updateId=(e)=>
    {
        setId(e.target.value);
    }

     const updateName=(e)=>
    {
        setName(e.target.value);
    }

     const updateCategory=(e)=>
    {
        setCategory(e.target.value);
    }

     const updateCost=(e)=>
    {
        setCost(e.target.value);
    }

     const updateQty=(e)=>
    {
        setQty(e.target.value);
    }

    const saveProduct=(e)=>
    {
        e.preventDefault();
        let p={id, name, cost, category,qty}
        console.log(p)

         axios.post("http://localhost:8080/pms",p)
        .then((res)=>console.log(res))
        .catch(err=>console.log(err))
        
    };

    return <>
    
        <h2>Create</h2>

        <form onSubmit={saveProduct}>
            <table className="table table-sm">
                <tr>
                    <td>Id</td>
                    <td><input type="text" onChange={updateId}></input></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" onChange={updateName}></input></td>
                </tr>
                <tr>
                    <td>Category</td>
                    <td><input type="text" onChange={updateCategory}></input></td>
                </tr>
                <tr>
                    <td>Cost</td>
                    <td><input type="text" onChange={updateCost}></input></td>
                </tr>
                 <tr>
                    <td>Quantity</td>
                    <td><input type="text" onChange={updateQty}></input></td>
                </tr>
                <tr>
                    <td><input type="reset" className="btn bg-danger"></input></td>
                    <td><input type="submit" value="Register" className="btn bg-success"></input></td>
                </tr>

            </table>
        </form>
    
    </>

}
