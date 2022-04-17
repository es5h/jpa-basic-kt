package hellojpa

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
class Member {
    @Id
    var id: Long? = null;

    @Column(name = "name", nullable = false)
    var name:String = "";

    var age: Int = 0;

    @Enumerated(EnumType.STRING)
    lateinit var roleType: RoleType;

    @Temporal(TemporalType.TIMESTAMP)
    lateinit var createdDate: Date;

    @Temporal(TemporalType.TIMESTAMP)
    lateinit var lastModifiedDate: Date;

    lateinit var testLocaldate: LocalDate;
    lateinit var testLocalDateTime : LocalDateTime

    @Lob
    lateinit var description: String;

    @Transient
    var systemValue: Int = 0;
}
