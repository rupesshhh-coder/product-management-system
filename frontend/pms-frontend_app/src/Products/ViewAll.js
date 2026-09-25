import { useEffect, useState } from "react";
import axios from "axios";

export default function ViewAllProduct()
{

    const[allProduct,setAllProduct]=useState([{"id":101,"name":"abc","cost":1.20,"category":"xxx","qty":10}])

    const getAllProduct=()=>
    {
        axios.get("http://localhost:8080/pms")
        .then((res)=>{
            setAllProduct(res.data);
            console.log(allProduct);
        })
        .catch((err)=>{
            console.log(err)
        });
    }


    useEffect(()=>{getAllProduct()},[])


    return<>

        <h2>View Alll</h2>

        <table className="table">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Category</th>
                <th>Cost</th>
                <th>Quantity</th>
            </tr>

        {
            allProduct.map((product,index)=>(
                <tr>
                    <td>{product.id}</td>
                    <td>{product.name}</td>
                    <td>{product.category}</td>
                    <td>{product.cost}</td>
                    <td>{product.qty}</td>
                </tr>
        ))
        }

        </table>

    </>

}
