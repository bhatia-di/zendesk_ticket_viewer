import React, { useState } from "react";
import ReactLoading from 'react-loading';
import * as APIURLS from "../../constants/APIConstants";
import * as Utils from "../../utils/Utils";
import TypeBadge from "../../components/TypeBadge";
import Accordion from 'react-bootstrap/Accordion';
import {Input} from 'reactstrap';
import DetailedTicketViewerBody from "./DetailedTicketViewerBody";
import "../../styles/index.css";
import { faClipboardList, faClipboardCheck, faChevronCircleLeft, faChevronCircleRight, faExclamationTriangle } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

export default function TicketViewerPage() {
  const [tickets, setTickets] = useState(null);
  const [meta, setMeta] = useState(null);
  const [pageSize, setPageSize] = useState(25);
  const [activeTicket, setActiveTicket] = useState(null);


  React.useEffect(() => {
  console.log("Fetching Tickets cause component mounted");

  fetchAllTickets();


  }, []);


  const fetchAllTickets = (pageLink) => {
    const metaPageLinkValue = pageLink + "_cursor";
    const metaPageValue = meta && meta.hasOwnProperty(metaPageLinkValue) ? meta[metaPageLinkValue] : null;
    let params = metaPageValue == null ? {"pageSize": pageSize} : {"page": metaPageValue, "pageSize": pageSize, "pageLink": pageLink};
    console.log(params);
    setTickets(null);

    fetch(APIURLS.getTicketsURL + "?" + new URLSearchParams(params).toString())
    .then(response => response.json())
                  .then(result => {
                      setTickets(result.tickets);
                      setMeta(result.meta);
                      }).catch((error) => {
                      console.error("Fetch API Call failed with an error" + error);
                      });

  };





  const useMetaAndSetPageLink = (pageLink) => {
            console.log("Fetching Tickets cause before or after clicked");
          fetchAllTickets(pageLink);
  };




  const subjectHeaderClicked = (activeTicket) => {
    setActiveTicket(activeTicket);

  };




  if (tickets) {
    return (
    <div className={"container-fluid"}>
    <div className={"card-layout"}>
       <h3 className={"color-aqua"}>
        <FontAwesomeIcon icon={faClipboardList} color="#1f939c" className={"mr-2"} />
        <span className={"ml-2"}>Let's view all tickets! </span>
       </h3>
    </div>

    <div className={"row mb-2"}>
        <div className={"col-4"}>
        </div>
        <div className={"col-8"}>

        <div className={"row cursor-pointer"}>
        <div className="col-3">
             <small className={"float-right"}> Total Count of Tickets: {tickets.length} </small>
        </div>
        <div className={"col-3"}>
          <a onClick={() => {useMetaAndSetPageLink("before")}} className={"p-1"}><FontAwesomeIcon icon={faChevronCircleLeft} color="#1f939c" size="lg" /></a>
          <a onClick={() => {useMetaAndSetPageLink("after")}} className={"p-1"} ><FontAwesomeIcon icon={faChevronCircleRight} color="#1f939c" size="lg" /></a>
          <span className={"p-1"}>Show </span>

        </div>
        <div className={"col-3 p-0"}>
            <Input onChange={(event) => {setPageSize(event?.target?.value)}}
                                id="pageSizeInput"
                                name="pageSizeInput"
                                value={pageSize}
                                className={"cursor-pointer"}
                                type="select"
                              >
                                <option value={25}>
                                  25
                                </option>
                                <option value={30}>
                                  30
                                </option>
                                <option value={35}>
                                  35
                                </option>
                                <option value={40}>
                                  40
                                </option>
                                <option value={50}>
                                  50
                                </option>
                              </Input>
        </div>
        <div className={"col-3"}>
        <span className={"float-left"}>Results</span>
        </div>
        </div>


        </div>

    </div>

    {
        !Utils.isArrayEmpty(tickets)

        ?  <Accordion>

                   {
                   tickets.map((ticket, index) =>

                     <Accordion.Item key={"ticketaccordion" + index} eventKey={"accordion" + index + ""}>
                         <Accordion.Header onClick={(event) => {subjectHeaderClicked("ticket-" + ticket.id)}} >
                                <h5>
                                <FontAwesomeIcon icon={faClipboardList} className={"m-1"} />
                                   {ticket.subject}</h5>
                                <TypeBadge type={ticket.type} />
                                <TypeBadge type={ticket.status} />



                         </Accordion.Header>
                         <Accordion.Body>
                               <DetailedTicketViewerBody ticketId={ticket.id} activeTicket={activeTicket} />

                         </Accordion.Body>

                     </Accordion.Item>




                   )
                   }
               </Accordion>

               : <div className="card-jumbotron">
                   <div className="container">
                     <h1 className="display-4 color-red"><FontAwesomeIcon icon={faExclamationTriangle} color="red" className={"mr-2"} />No Tickets Available</h1>
                     <p className="lead">Opps! No tickets available for view. Please hit refresh!</p>
                   </div>
                 </div>
    }

    </div>


    );

  } else {
   return(
       <div className={"container-fluid"}>
            <ReactLoading type={"spinningBubbles"} color={"#1f939c"} height={'20%'} width={'20%'} />
      </div>

      );

  }





}
