import React, { useState } from "react";
import ReactLoading from 'react-loading';
import * as APIURLS from "../../constants/APIConstants";
import * as Utils from "../../utils/Utils";
import TypeBadge from "../../components/TypeBadge";
import Accordion from 'react-bootstrap/Accordion';
import {Input} from 'reactstrap';
import "../../styles/index.css";


export default function DetailedTicketViewerBody(detailedTicketViewerBodyProps) {
    const [ticket, setTicket] = useState(null);

    React.useEffect(() => {

    if (Utils.isNonNull(detailedTicketViewerBodyProps.activeTicket)) {
        const activeTicket = detailedTicketViewerBodyProps.activeTicket.split("-")[1];
                if (parseInt(activeTicket) === detailedTicketViewerBodyProps.ticketId) {
                    console.log("-----------Execute fetch--------------");
                    fetchTicketWithId(activeTicket);
                }


    }



    }, [detailedTicketViewerBodyProps.ticketId, detailedTicketViewerBodyProps.activeTicket]);


    const fetchTicketWithId = (ticketId) => {

        setTicket(null);
        const params = {ticketId: ticketId};

        fetch(APIURLS.getTicketWithIdURL + "?" + new URLSearchParams(params).toString())
        .then(response => response.json())
                      .then(result => {
                          setTicket(result.ticket);
                          }).catch((error) => {
                          console.error("Fetch API Call failed with an error" + error);
                          });

      };



    if(ticket) {
        return (
       <div className={"container-fluid"}>

       </div>);

    }
   else {
      return(
          <div className={"container-fluid"}>
               <ReactLoading type={"spinningBubbles"} color={"#1f939c"} height={'10%'} width={'10%'} />
         </div>

         );

   }



}