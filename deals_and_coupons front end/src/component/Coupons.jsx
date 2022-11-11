
import React, { useState, useEffect } from "react";
import getallcoupons from "./getallcoupons";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import AddToCartCouponsAxios from "./AddToCartCouponsAxios";


function Coupons() {
  const [allcoupons, setallcoupons] = useState([])
  useEffect(() => {
    getallcoupons.getallcoupons().then((value) => {
      setallcoupons(value)
      console.log(value)
    });
    console.log(allcoupons)
  }, [])


  const cardItem = (item) => {
    const addtocart = () => {
      console.log(item.category)
      let body = {category:item.category, offer:item.offer, companyName:item.companyName, price:item.price, expiryDate:item.expiryDate}
  AddToCartCouponsAxios.AddToCartCouponsAxios(body).then((value) => {
    alert("item added to cart")
  })
    }

    return (

      <Card className="my-5 py-4" style={{ width: "30rem" }}>
        <Card.Img  src="/assets/6.jpg" />
        <Card.ImgOverlay>

        <Card.Body className="text-center my-5">
        <Card.Title>{item.offer}</Card.Title>


          <Card.Text>Category : {item.category}</Card.Text>
          
          <Card.Text> Company Name : {item.companyName}</Card.Text>
          
          <Card.Text> Price : ₹{item.price}</Card.Text>
          <Card.Text> Expiry Date : {item.expiryDate}</Card.Text>
          <Button onClick={addtocart} variant="primary">Add to cart</Button>

        </Card.Body>
        </Card.ImgOverlay>
      </Card>

    )
  }
  return (
    <Container id="coupons_all">
      <Row className="justify-content-around">
        {/* using React.childer to Arrya to set key automatically for the items of list */}
        {React.Children.toArray(allcoupons.map(cardItem))}
      </Row>
    </Container>

  )
}
export default Coupons;