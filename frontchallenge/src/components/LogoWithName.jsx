import Logo from "../assets/imgs/labseqNB.png";

export default function LogoWithName () {

    return (
        <>
            <div className="logoMain">
                <div className="logoImg">
                    <img src={Logo} alt="Labseq Logo" />
                </div>
            </div>
        </>
    )
}